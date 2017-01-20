package com.ch.happyhours.communication.web.controller;


import com.ch.happyhours.communication.service.MailService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@Api(basePath = "/", value = "mail", description = "Operations with mailing", produces = "application/json")
@RestController
@RequestMapping("/ws/mail")
public class MailController {

    private Logger logger = LoggerFactory.getLogger(MailController.class);

    @Inject
    private MailService mailService;

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/activation/send",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void sendMail(@RequestBody String mail) {


    }
}
