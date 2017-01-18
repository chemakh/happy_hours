package com.ch.happyhours.auth;

import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * Created by Chemakh on 20/12/2016.
 */
public class TestClass
{

//    public static void main(String[] args)
//    {
//        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("happy-hours.jks"), "happyHourskey".toCharArray());
//
//        KeyPair key=keyStoreKeyFactory.getKeyPair("happy-hours");
//
//        System.out.println(new String(Base64.encode(key.getPrivate().getEncoded())));
//    }
}
