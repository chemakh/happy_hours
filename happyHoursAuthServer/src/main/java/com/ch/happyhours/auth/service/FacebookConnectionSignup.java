package com.ch.happyhours.auth.service;

import com.ch.happyhours.auth.domain.User;
import com.ch.happyhours.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

/**
 * Created by Chemakh on 02/02/2017.
 */
@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        User user = new User();
        user.setFirstName(connection.getDisplayName());
        user.setPassword("12345678");
        userRepository.save(user);
        return user.getUsername();
    }
}


