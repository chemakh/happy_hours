package com.ch.happyhours.service.service;


import com.ch.happyhours.service.Exception.HappyHoursException;
import com.ch.happyhours.service.domain.Client;
import com.ch.happyhours.service.domain.Manager;
import com.ch.happyhours.service.domain.User;
import com.ch.happyhours.service.repository.UserRepository;
import com.ch.happyhours.service.restclients.RestCLientCallback;
import com.ch.happyhours.service.security.SecurityUtils;
import com.ch.happyhours.service.utils.BusinessAndDomainConverter;
import com.ch.happyhours.service.utils.TokenUtil;
import com.ch.happyhours.service.web.dto.UserDto;
import com.ch.happyhours.service.web.error.FieldErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Inject
    private UserRepository userRepository;


    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    private BusinessAndDomainConverter converter;

    @Inject
    private RestCLientCallback restCLientCallback;

    @Transactional(readOnly = true)
    public User getCurrentUser() throws HappyHoursException {
        String currentUserName = SecurityUtils.getCurrentUserLogin();

        if (currentUserName == null || currentUserName.isEmpty())
            throw HappyHoursException.actionUnauthorizedErrorBuilder("Acces Denied");

        return userRepository.findOneByEmail(currentUserName).map(auth -> {
            auth.getAuthorities().size();
            return auth;
        }).orElseThrow(() -> HappyHoursException.resourceNotFoundExceptionBuilder(User.class, currentUserName, HappyHoursException.WITH_EMAIL));

    }


    public UserDto requestPasswordReset(String mail) throws HappyHoursException {
        return userRepository.findOneByEmail(mail)
                .filter(User::isActivated)
                .map(user -> {
                    user.setResetPasswordKey(TokenUtil.generateCode());
                    userRepository.save(user);
                    UserDto userDto = converter.fromUserToBusiness(user);
                    restCLientCallback.sendPasswordResetEmail(userDto);
                    return userDto;
                }).orElseThrow(() -> HappyHoursException.resourceNotFoundExceptionBuilder(User.class, mail, HappyHoursException.WITH_EMAIL));
    }

    public UserDto completePasswordReset(String newPassword, String key) throws HappyHoursException {
        logger.debug("Reset user password for reset key {}", key);

        return userRepository.findOneByResetPasswordKey(key)
                .filter(User::isActivated)
                .map(user -> {
                    user.setPassword(passwordEncoder.encode(newPassword));
                    user.setResetPasswordKey(null);
                    userRepository.save(user);
                    return converter.fromUserToBusiness(user);
                })
                .orElseThrow(() -> HappyHoursException.invalidCodeExceptionBuilder("Password Key"));
    }

    public boolean changePassword(String oldPassword, String newPassword) throws HappyHoursException {
        logger.debug("Reset user password for reset");

        User user = getCurrentUser();
        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        } else {
            throw HappyHoursException.validationErrorBuilder(new FieldErrorDTO("User", "Password", "must_match"));
        }

        return true;

    }

    public boolean requestEmailVerification() throws HappyHoursException {
        logger.debug("Reset user email ");
        User user = getCurrentUser();
        user.setEmailKey(TokenUtil.generateCode());
        userRepository.save(user);
        UserDto userDto = converter.fromUserToBusiness(user);
        userDto.setEmail(user.getEmail());
        restCLientCallback.sendActivationEmailMobile(userDto);
        return true;

    }
    public UserDto activateRegistration(String key) throws HappyHoursException {
        logger.debug("Activating user for activation key {}", key);

        User currentUser = getCurrentUser();

        return userRepository.findOneByEmailKey(key)
                .filter(user -> user.equals(currentUser))
                .map(user -> {
                    user.setActivated(true);
                    user.setEmailKey(null);
                    userRepository.save(user);
                    logger.debug("Activated user: {}", user);



                    return converter.fromUserToBusiness(user);
                }).orElseThrow(() -> HappyHoursException.invalidCodeExceptionBuilder("Email Key"));
    }

    public void checkIfEmailIsUsed(User user) throws HappyHoursException {
        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
            Optional<User> find = userRepository.findOneByEmail(user.getEmail()).
                    filter(us -> user.getReference() == null || user.getReference().isEmpty() || !us.getReference().equals(user.getReference()));
            if (find.isPresent()) {
                throw HappyHoursException.identifierAlreadyInUseExceptionBuilderBuilder("Email", user.getEmail());
            }

        }

    }

    public Object getCurrentUserDto(User user) {
        if (SecurityUtils.isAdmin(user)) {
            return converter.fromUserToBusiness(user);
        } else if (SecurityUtils.isManager(user)) {
            return converter.fromManagerToBusiness((Manager) user);
        } else if (SecurityUtils.isClient(user)) {
            return converter.fromClientToBusiness((Client) user);
        } else {
            return converter.fromUserToBusiness(user);
        }
    }




    public Object verifyEmail(String code) throws HappyHoursException {
        logger.debug("Verify user email with  key {}", code);
        User currentUser = getCurrentUser();
        return userRepository.findOneByEmailKey(code)
                .filter(user -> user.equals(currentUser))
                .map(user -> {
                    user.setEmailKey(null);
                    user.setIsMailVerified(true);
                    if (user.isFirstConnection() && user.isMobileVerified()) {
                        user.setFirstConnection(false);
                        restCLientCallback.sendAccountConfirmationEmail(converter.fromUserToBusiness(user));
                    }
                    user = userRepository.save(user);
                    logger.debug("verify  email : {}", user.getEmail());

                    return getCurrentUserDto(user);
                })
                .orElseThrow(() -> HappyHoursException.invalidCodeExceptionBuilder("Email Key"));
    }


}
