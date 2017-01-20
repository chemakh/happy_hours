package com.ch.happyhours.service.web.dto;



import com.ch.happyhours.service.domain.Sex;
import com.ch.happyhours.service.utils.jackson.SexDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserDto
{

    private String reference;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private boolean activated = false;

    private String langKey;

    private String emailKey;

    private String resetPasswordKey;

    private List<String> Authorities;

    private String smsKey;

    private  boolean isMailVerified ;

    private boolean isMobileVerified ;

    @NotNull
    @JsonDeserialize(using = SexDeserializer.class)
    private Sex sex;


    public UserDto()
    {
    }

    public UserDto(String email, boolean activated, String langKey)
    {
        this.email = email;
        this.activated = activated;
        this.langKey = langKey;
    }


    public boolean isActivated()
    {
        return activated;
    }

    public void setActivated(boolean activated)
    {
        this.activated = activated;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


    public String getLangKey()
    {
        return langKey;
    }

    public void setLangKey(String langKey)
    {
        this.langKey = langKey;
    }


    public String getReference()
    {
        return reference;
    }

    public void setReference(String reference)
    {
        this.reference = reference;
    }

    public List<String> getAuthorities()
    {
        return Authorities;
    }

    public void setAuthorities(List<String> authorities)
    {
        Authorities = authorities;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    public String getResetPasswordKey() {
        return resetPasswordKey;
    }

    public void setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
    }


    public boolean isMailVerified() {
        return isMailVerified;
    }

    public void setIsMailVerified(boolean isMailVerified) {
        this.isMailVerified = isMailVerified;
    }

    public boolean isMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(boolean isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public String getEmailKey() {
        return emailKey;
    }

    public void setEmailKey(String emailKey) {
        this.emailKey = emailKey;
    }

    public String getSmsKey() {
        return smsKey;
    }

    public void setSmsKey(String smsKey) {
        this.smsKey = smsKey;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
