package com.ch.happyhours.service.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Chemakh on 23/01/2017.
 */

@Entity
@Table(name = "avis", indexes = {@Index(name = "index_avis_reference", columnList = "reference", unique = true)})
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "reference")
    private String reference;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    private String texte;

    private LocalDateTime heure;
}
