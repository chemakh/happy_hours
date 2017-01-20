package com.ch.happyhours.service.restclients;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "happy-hours-communication-mail", url = "${happy-hours.feign.communication}")
@EnableHystrix
public interface MailClient
{

    @RequestMapping(method = RequestMethod.POST, value = "/mail/send", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void sendActivationEmailMobile(String userDto);
}

