package com.ch.happyhours.communication.service;



import com.ch.happyhours.communication.config.HappyHoursProperties;
import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService
{

    private final static Logger log = LoggerFactory.getLogger(MailService.class);

    @Inject
    private HappyHoursProperties happyHoursProperties;

    @Inject
    private JavaMailSenderImpl javaMailSender;

    @Inject
    private MessageSource messageSource;

    @Value("${happy-hours.mail.admin}")
    private String adminEmail;

    @Value("${happy-hours.activationUrl}")
    private String activationUrl;

    @Async
    public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml)
    {
        log.debug("Send e-mail[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
                isMultipart, isHtml, to, subject, content);

        log.info("Send e-mail[multipart '{}' and html '{}'] to '{}' with subject '{}'",
                isMultipart, isHtml, to, subject);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper message;
        try
        {
            message = new MimeMessageHelper(mimeMessage, isMultipart, CharEncoding.UTF_8);
            message.setTo(to.trim());
            message.setFrom(happyHoursProperties.getMail().getFrom());
            message.setSubject(subject);
            message.setText(content, isHtml);
            javaMailSender.send(mimeMessage);
            log.debug("Sent e-mail to User '{}'", to);
        }
        catch (MessagingException e)
        {
            log.warn("E-mail could not be sent to user '{}', exception is: {}", to, e);
        }


    }


}
