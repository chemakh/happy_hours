package com.ch.happyhours.service.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Arrays;

//@Configuration
public class FlyWayConfig
{
    @Inject
    private DataSource dataSource;

    @Inject
    private Environment env;

    @Bean
    @DependsOn("entityManagerFactory")
    public Flyway flyway()
    {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        if (Arrays.asList(env.getActiveProfiles()).contains("dev"))
        {
            flyway.setLocations("classpath:db/dev/migration");
        }
        else if (Arrays.asList(env.getActiveProfiles()).contains("prod"))
        {
            flyway.setLocations("classpath:db/prod/migration");
        }
        flyway.setBaselineOnMigrate(true);
        flyway.setBaselineVersionAsString("0");
        flyway.setEncoding("UTF-8");
        flyway.setValidateOnMigrate(false);
        flyway.migrate();
        return flyway;
    }


}
