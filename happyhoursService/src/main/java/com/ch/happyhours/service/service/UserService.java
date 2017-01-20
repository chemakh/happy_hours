package com.ch.happyhours.service.service;


import com.ch.happyhours.service.domain.User;
import com.ch.happyhours.service.repository.UserRepository;
import com.ch.happyhours.service.restclients.RestCLientCallback;
import com.ch.happyhours.service.utils.BusinessAndDomainConverter;
import com.ch.happyhours.service.web.dto.UserDto;
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


    public Optional<UserDto> getUserByActivationUser(String key) {
        logger.debug("Get user by activation key {}", key);
        return userRepository.findOneByEmailKey(key)
                .map(converter::fromUserToBusiness);
    }


}
