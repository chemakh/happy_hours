package com.ch.happyhours.service.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
@Table(name = "user", indexes = {@Index(name = "index_user_reference", columnList = "reference", unique = true)})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@DiscriminatorValue("user")
@DiscriminatorOptions(force = false)
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "reference")
    private String reference;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "password", length = 60, nullable = true)
    private String password;

    @Column(name = "activated", nullable = false)
    private boolean activated = false;

    @Column(name = "lang_key", length = 5)
    private String langKey;

    @Column(name = "email_key", length = 20)
    private String emailKey;

    @Column(name = "reset_password_key", length = 20)
    private String resetPasswordKey;

    @Column(name = "sms_Key", length = 4)
    private String smsKey;

    @Column(name = "is_mail_verified", columnDefinition = "tinyint(1) default 0")
    private boolean isMailVerified = false;

    @Column(name = "is_mobile_verified", columnDefinition = "tinyint(1) default 0")
    private boolean isMobileVerified = false;

    @Column(name = "first_connection", columnDefinition = "tinyint(1) default 0")
    private boolean firstConnection = true;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "deletion_date")
    private LocalDateTime deletionDate = null;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Authority> authorities = new HashSet<>();

    public Set<Authority> getAuthorities()
    {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities)
    {
        this.authorities = authorities;
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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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


    public String getResetPasswordKey()
    {
        return resetPasswordKey;
    }

    public void setResetPasswordKey(String resetPasswordKey)
    {
        this.resetPasswordKey = resetPasswordKey;
    }

    public boolean isMailVerified()
    {
        return isMailVerified;
    }

    public void setIsMailVerified(boolean isMailVerified)
    {
        this.isMailVerified = isMailVerified;
    }

    public boolean isMobileVerified()
    {
        return isMobileVerified;
    }

    public void setIsMobileVerified(boolean isMobileVerified)
    {
        this.isMobileVerified = isMobileVerified;
    }

    public String getEmailKey()
    {
        return emailKey;
    }

    public void setEmailKey(String emailKey)
    {
        this.emailKey = emailKey;
    }

    public String getSmsKey()
    {
        return smsKey;
    }

    public void setSmsKey(String smsKey)
    {
        this.smsKey = smsKey;
    }

    public Sex getSex()
    {
        return sex;
    }

    public void setSex(Sex sex)
    {
        this.sex = sex;
    }

    public boolean isFirstConnection()
    {
        return firstConnection;
    }

    public void setFirstConnection(boolean firstConnection)
    {
        this.firstConnection = firstConnection;
    }

    public LocalDateTime getDeletionDate()
    {
        return deletionDate;
    }

    public void setDeletionDate(LocalDateTime deletionDate)
    {
        this.deletionDate = deletionDate;
    }


    @Override
    public boolean equals(Object object)
    {
        return Optional.ofNullable(object).filter(obj -> obj instanceof User).map(obj -> (User) obj).
                filter(ag -> getId() == null || Objects.equals(ag.getReference(), this.reference)).
                filter(ag -> getId() != null || Objects.equals(ag, this)).
                isPresent();
    }

    @Override
    public int hashCode()
    {
        if (this.getReference() != null)
            return this.getReference().hashCode();
        else if (this.getId() != null)
            return this.getId().hashCode();
        else
            return super.hashCode();
    }

}
