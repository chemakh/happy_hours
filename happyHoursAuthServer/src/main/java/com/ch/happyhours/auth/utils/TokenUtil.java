package com.ch.happyhours.auth.utils;

import org.apache.commons.lang.RandomStringUtils;


public final class TokenUtil
{

    private static final int DEF_COUNT_KEY = 20;

    private static final int DEF_COUNT_PASSWORD = 8;

    private static final int DEF_COUNT_MIN = 4;

    private TokenUtil()
    {
    }

    public static String generatePassword()
    {
        return RandomStringUtils.randomAlphanumeric(DEF_COUNT_PASSWORD);
    }

    public static String generateReference()
    {
        return RandomStringUtils.randomAlphanumeric(DEF_COUNT_KEY);
    }

    public static String generateCode()
    {
        return RandomStringUtils.randomNumeric(DEF_COUNT_MIN);
    }

    public static String generateImageName()
    {
        return RandomStringUtils.randomAlphabetic(DEF_COUNT_KEY);
    }

    public static String generateBillReference()
    {
        return RandomStringUtils.randomAlphanumeric(DEF_COUNT_KEY);
    }

}
