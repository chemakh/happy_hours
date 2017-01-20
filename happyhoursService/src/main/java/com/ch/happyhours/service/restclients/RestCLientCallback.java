package com.ch.happyhours.service.restclients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class RestCLientCallback implements MailClient,UserClient {

    private static Logger logger = LoggerFactory.getLogger(RestCLientCallback.class);

    @Inject
    private MailClient mailClient;

    @Inject
    private UserClient userClient;


    @Override
    @HystrixCommand(fallbackMethod = "sendActivationMailFallback")
    public void sendActivationEmailMobile(String userDto) {
        mailClient.sendActivationEmailMobile(userDto);
    }



    public void sendActivationMailFallback(String userDto) {
        logger.error("Activation email couldn't be sent to the receiver : {}", userDto);
    }

    @Override
    public ResponseEntity<JSONObject> authenticate(String secret, String clientId, String grantType, String scope, String username, String password) {
        return userClient.authenticate(secret, clientId, grantType, scope, username, password);
    }

    @Override
    public ResponseEntity<JSONObject> refreshToken(String secret, String clientId, String grantType, String token) {
        return userClient.refreshToken(secret, clientId, grantType, token);
    }
}
