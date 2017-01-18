package com.ch.happyhours.auth.service;

import com.ch.happyhours.auth.domain.User;
import com.ch.happyhours.auth.exception.UserDeletedException;
import com.ch.happyhours.auth.exception.UserNotActivatedException;
import com.ch.happyhours.auth.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

    private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {

        logger.info("Authenticating the user {}", email);
        Optional<User> userFound = repository.findOneByEmail(email);
        return userFound.map(user -> {
            if (!user.isActivated())
            {
                if (user.getDeletionDate() == null)
                    throw new UserNotActivatedException("User " + email + " has not been activated yet");
                else throw new UserDeletedException("User " + email + " has been deleted");
            }
            return user;
        }).orElseThrow(() -> new UsernameNotFoundException("user " + email + " Not found in the database"));
    }
}
