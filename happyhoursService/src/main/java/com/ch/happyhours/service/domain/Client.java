package com.ch.happyhours.service.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Chemakh on 23/01/2017.
 */
@SuppressWarnings("unused")
@DiscriminatorValue("Client")
@Entity
@Table(name = "client")
public class Client extends User {

    @Column(name = "photoUrl", nullable = true)
    private String photoUrl;

    @Column(name = "temp_password", length = 20)
    private String tempPassword;

    public Client(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTempPassword() {
        return tempPassword;
    }

    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }
}
