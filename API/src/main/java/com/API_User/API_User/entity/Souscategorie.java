package com.API_User.API_User.entity;
import com.API_User.API_User.dto.SousCategorieDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "souscategorie")
public class Souscategorie {
    @Id
    @Column(name="code_souscategorie", length = 45)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "souscategorie_generator")

    private int code_souscategorie;

    @Column(name="nom_souscategorie", length = 255)
    private String nom_souscategorie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categorie_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Categorie categorie;

    public int getCode_souscategorie() {
        return code_souscategorie;
    }

    public void setCode_souscategorie(int code_souscategorie) {
        this.code_souscategorie = code_souscategorie;
    }

    public String getNom_souscategorie() {
        return nom_souscategorie;
    }

    public void setNom_souscategorie(String nom_souscategorie) {
        this.nom_souscategorie = nom_souscategorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


// getters and setters


}
