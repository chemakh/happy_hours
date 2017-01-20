package com.ch.happyhours.communication.config.apidoc;

import com.ch.happyhours.communication.config.HappyHoursProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.inject.Inject;
import java.util.Date;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration
{

    private final Logger log = LoggerFactory.getLogger(SwaggerConfiguration.class);

    public static final String DEFAULT_INCLUDE_PATTERN = "/.*";

    @Inject
    private HappyHoursProperties happyHoursProperties;


    @Bean
    public Docket swaggerSpringfoxDocket()
    {
        log.debug("Starting Swagger");
        StopWatch watch = new StopWatch();
        watch.start();
        Contact contact = new Contact(
                happyHoursProperties.getSwagger().getContactName(),
                happyHoursProperties.getSwagger().getContactUrl(),
                happyHoursProperties.getSwagger().getContactEmail());

        ApiInfo apiInfo = new ApiInfo(
                happyHoursProperties.getSwagger().getTitle(),
                happyHoursProperties.getSwagger().getDescription(),
                happyHoursProperties.getSwagger().getVersion(),
                happyHoursProperties.getSwagger().getTermsOfServiceUrl(),
                contact,
                happyHoursProperties.getSwagger().getLicense(),
                happyHoursProperties.getSwagger().getLicenseUrl());

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .select().apis(RequestHandlerSelectors.basePackage("com.ch.happyhours.communication.web.controller"))
                .paths(regex(DEFAULT_INCLUDE_PATTERN))
                .build();
        watch.stop();
        log.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
        return docket;
    }
}
