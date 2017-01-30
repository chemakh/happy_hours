package com.ch.happyhours.service.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Chemakh on 30/01/2017.
 */

@Entity
@Table(name = "product", indexes = {@Index(name = "index_product_reference", columnList = "reference", unique = true)})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "reference")
    private String reference;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Manager createdBy;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    private String description;

    private BigDecimal price;

    @Column(name = "photoName", nullable = true)
    private String photoName;

    public Product() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public Manager getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Manager createdBy) {
        this.createdBy = createdBy;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }
}
