package com.ch.happyhours.service.config;



import java.time.format.DateTimeFormatter;

public final class Constants
{

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";

    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    public static final DateTimeFormatter LocalDateTimeFormatterWithOutZone =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final DateTimeFormatter ESDateFormatter=
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public static final DateTimeFormatter LocalDateFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final DateTimeFormatter LocalDateFormatterSwiss =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static final DateTimeFormatter LocalTimeFormatter =
            DateTimeFormatter.ofPattern("HH:mm");


    private Constants()
    {
    }
}
