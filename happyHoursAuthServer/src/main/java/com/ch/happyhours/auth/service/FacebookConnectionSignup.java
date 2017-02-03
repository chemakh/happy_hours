package com.ch.happyhours.auth.service;

import com.ch.happyhours.auth.domain.Authority;
import com.ch.happyhours.auth.domain.Client;
import com.ch.happyhours.auth.domain.Sex;
import com.ch.happyhours.auth.domain.User;
import com.ch.happyhours.auth.repository.AuthorityRepository;
import com.ch.happyhours.auth.repository.ClientRepository;
import com.ch.happyhours.auth.repository.UserRepository;
import com.ch.happyhours.auth.utils.AuthoritiesConstants;
import com.ch.happyhours.auth.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.support.AbstractConnection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Chemakh on 02/02/2017.
 */
@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public String execute(Connection<?> connection) {

        Facebook facebook = ((Connection<Facebook>) connection).getApi();
        org.springframework.social.facebook.api.User user = facebook.fetchObject("me", org.springframework.social.facebook.api.User.class);
        UserProfile profile = connection.fetchUserProfile();

        Client client = new Client();
        client.setFirstName(user.getFirstName());
        client.setLastName(user.getLastName());
        client.setEmail(profile.getEmail());
        client.setReference(TokenUtil.generateReference());
        client.setSex(Sex.fromString(user.getGender().substring(0,1)));
        client.setPassword(new BCryptPasswordEncoder().encode("12345678"));
        client.setActivated(true);
        client.setPhotoUrl(connection.getProfileUrl());
        Optional<Authority> authority = authorityRepository.findOneByName(AuthoritiesConstants.CLIENT);
        Set<Authority> authorities = new HashSet<>();
        authorities.add(authority.get());
        client.setAuthorityList(authorities);

        clientRepository.save(client);
        return client.getUsername();
    }


}


