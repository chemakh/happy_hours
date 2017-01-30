package com.ch.happyhours.service.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Chemakh on 23/01/2017.
 */

@SuppressWarnings("unused")
@DiscriminatorValue("Restaurant")
@Entity
@Table(name = "restaurant")
public class Restaurant extends Establishment {


    @Column(name = "type_cuisine")
    private String typeCuisine;

    @Column(name = "type_de_restaurant")
    private String typeDeRestaurant;

    private String alcool;
    private String ouverture;
    private String fermeture;

    private BigDecimal priceMin;
    private BigDecimal priceMax;


    public Restaurant() {
    }

    public String getTypeCuisine() {
        return typeCuisine;
    }

    public void setTypeCuisine(String typeCuisine) {
        this.typeCuisine = typeCuisine;
    }

    public String getAlcool() {
        return alcool;
    }

    public void setAlcool(String alcool) {
        this.alcool = alcool;
    }

    public String getOuverture() {
        return ouverture;
    }

    public void setOuverture(String ouverture) {
        this.ouverture = ouverture;
    }

    public String getFermeture() {
        return fermeture;
    }

    public void setFermeture(String fermeture) {
        this.fermeture = fermeture;
    }

    public String getTypeDeRestaurant() {
        return typeDeRestaurant;
    }

    public void setTypeDeRestaurant(String typeDeRestaurant) {
        this.typeDeRestaurant = typeDeRestaurant;
    }

    public BigDecimal getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(BigDecimal priceMin) {
        this.priceMin = priceMin;
    }

    public BigDecimal getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(BigDecimal priceMax) {
        this.priceMax = priceMax;
    }
}
