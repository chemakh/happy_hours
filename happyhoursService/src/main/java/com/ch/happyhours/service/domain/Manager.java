package com.ch.happyhours.service.domain;

import javax.persistence.*;

/**
 * Created by Chemakh on 23/01/2017.
 */

@SuppressWarnings("unused")
@DiscriminatorValue("Manager")
@Entity
@Table(name = "manager")
public class Manager extends User {


    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "fonction")
    @Enumerated(EnumType.STRING)
    private ManagerFct fonction;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "establishment_id",nullable = true)
    private Establishment establishment;

    public Manager() {
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public ManagerFct getFonction() {
        return fonction;
    }

    public void setFonction(ManagerFct fonction) {
        this.fonction = fonction;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }
}
