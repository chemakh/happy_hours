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

    @Column(name = "photoName", nullable = true)
    private String photoName;
}
