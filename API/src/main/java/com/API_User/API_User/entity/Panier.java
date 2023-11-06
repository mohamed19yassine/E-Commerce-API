package com.API_User.API_User.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier {

    @Id
    @Column(name="ref_panier", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ref_panier;
 /*   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_commande")
    private Commande commande;*/
}
