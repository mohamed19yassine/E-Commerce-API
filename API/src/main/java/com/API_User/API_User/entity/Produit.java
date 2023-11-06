package com.API_User.API_User.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @Column(name="code_produit", length = 45)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produit_generator")
    private int code_produit;

    @Column(name="designation", length = 255)
    private String designation;

    @Column(name="description", length = 255)
    private String description;
    @Column(name="prix", length = 255)
    private double prix;
    @Column(name="image", length = 255)
    private String image;

    @Column(name="qte_stocke", length = 255)
    private int qte_stocke;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "souscategorie_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Souscategorie souscategorie;

    public int getCode_produit() {
        return code_produit;
    }

    public void setCode_produit(int code_produit) {
        this.code_produit = code_produit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQte_stocke() {
        return qte_stocke;
    }

    public void setQte_stocke(int qte_stocke) {
        this.qte_stocke = qte_stocke;
    }

    public Souscategorie getSouscategorie() {
        return souscategorie;
    }

    public void setSouscategorie(Souscategorie souscategorie) {
        this.souscategorie = souscategorie;
    }

    // getters and setters
}
