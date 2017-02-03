package com.ch.happyhours.auth.domain;

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

    public Client() {

    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
