package com.ch.happyhours.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")

                        //for Test Purpose

                .antMatchers("/ws/user/authenticate")
                .antMatchers("/ws/user/get")
                .antMatchers("/ws/user/password/reset")
                .antMatchers("/ws/user/password/reset/finish")
                .antMatchers("/ws/user/token/refresh")

                .antMatchers("/v2/api-docs")

                .antMatchers("/angular/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().realmName("happy-hours-service")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .requestMatchers().antMatchers("/oauth/authorize")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/authorize").authenticated()
                .and()
                .headers().disable();
    }
}
