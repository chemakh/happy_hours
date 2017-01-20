package com.ch.happyhours.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by Chemakh on 17/01/2017.
 */


@Component
public class MessageFactory {


    private static MessageSource messageSource;

    @Autowired
    public MessageFactory(MessageSource messageSource) {
        MessageFactory.messageSource = messageSource;
    }

    public static String getMessage(String s, Object[] objects, String lang) {
        return messageSource.getMessage(s, objects, lang != null ? new Locale(lang) : new Locale("en"));
    }

    public static String getMessage(String s, Object[] objects) {
        try {
            return messageSource.getMessage(s, objects, new Locale("en"));
        }catch (NoSuchMessageException ex)
        {
            return messageSource.getMessage("happy-hours.exception.thrown", null, new Locale("en"));
        }

    }

}
