package com.ch.happyhours.service.restclients;


import com.ch.happyhours.service.web.dto.UserDto;
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
    void sendActivationEmailMobile(UserDto userDto);

    @RequestMapping(method = RequestMethod.POST, value = "/mail/password/reset", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void sendPasswordResetEmail(UserDto userDto);

    @RequestMapping(method = RequestMethod.POST, value = "/mail/account/confirm", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void sendAccountConfirmationEmail(UserDto userDto);
}

