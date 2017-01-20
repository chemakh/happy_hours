package com.ch.happyhours.service;

import com.ch.happyhours.service.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


public class HappyHoursServiceApplicationWebXml extends SpringBootServletInitializer
{

    private final Logger log = LoggerFactory.getLogger(HappyHoursServiceApplicationWebXml.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.profiles(addDefaultProfile())
                .sources(HappyHoursServiceApplication.class);
    }

    private String addDefaultProfile()
    {
        String profile = System.getProperty("spring.profiles.active");
        if (profile != null && !profile.isEmpty())
        {
            log.info("Running with Spring profile(s) : {}", profile);
            return profile;
        }

        log.warn("No Spring profile configured, running with default configuration");
        return Constants.SPRING_PROFILE_DEVELOPMENT;
    }
}
