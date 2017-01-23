package com.ch.happyhours.service.domain;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * Created by Chemakh on 23/01/2017.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
@Table(name = "establishment", indexes = {@Index(name = "index_establishment_reference", columnList = "reference", unique = true)})
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@DiscriminatorValue("establishment")
@DiscriminatorOptions(force = false)
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "nom")
    private String nom;

    @Column(name = "pays")
    private String pays;

    @Column(name = "region")
    private String region;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "description")
    private String description;

    @Column(name = "photoName", nullable = true)
    private String photoName;

    @Column(name = "infoSupp")
    private String infoSupp;

    @Column(name = "tel")
    private String tel;

    @Column(name = "site_web")
    private String siteWeb;

    @Column(name = "facebook")
    private String facebook;

    @Embedded
    private GeoPoint location;

    private boolean creditCard;

    private String musique;

    private boolean haveReservation;




    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private EstablishmentCategory category;


    public Establishment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getInfoSupp() {
        return infoSupp;
    }

    public void setInfoSupp(String infoSupp) {
        this.infoSupp = infoSupp;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public EstablishmentCategory getCategory() {
        return category;
    }

    public void setCategory(EstablishmentCategory category) {
        this.category = category;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCreditCard() {
        return creditCard;
    }

    public void setCreditCard(boolean creditCard) {
        this.creditCard = creditCard;
    }

    public String getMusique() {
        return musique;
    }

    public void setMusique(String musique) {
        this.musique = musique;
    }

    public boolean isHaveReservation() {
        return haveReservation;
    }

    public void setHaveReservation(boolean haveReservation) {
        this.haveReservation = haveReservation;
    }
}
