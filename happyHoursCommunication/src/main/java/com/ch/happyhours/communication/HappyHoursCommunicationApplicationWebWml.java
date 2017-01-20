package com.ch.happyhours.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class HappyHoursCommunicationApplicationWebWml extends SpringBootServletInitializer
{

    private final Logger log = LoggerFactory.getLogger(HappyHoursCommunicationApplicationWebWml.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.profiles(addDefaultProfile())
                .sources(HappyHoursCommunicationApplication.class);
    }

    private String addDefaultProfile()
    {
        String profile = System.getProperty("spring.profiles.active");
        if (profile != null)
        {
            log.info("Running with Spring profile(s) : {}", profile);
            return profile;
        }

        log.warn("No Spring profile configured, running with default configuration");
        return "dev";
    }
}
