package com.ch.happyhours.service.domain;


import java.util.*;

public enum Sex
{
    M,
    F,
    UNDEFINED;

    public static Sex fromString(final String sex)
    {

        return sex != null ?
                Arrays.stream(values()).filter(val -> Objects.equals(val.toString(), sex.toUpperCase().trim())).findFirst().orElse(null)
                : null;

    }

    public static boolean isMan(Sex sex)
    {

        return sex == M;
    }

    private static final List<Sex> VALUES = Collections.unmodifiableList(Arrays.asList(Sex.F,Sex.M));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Sex randomSex()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }


}
