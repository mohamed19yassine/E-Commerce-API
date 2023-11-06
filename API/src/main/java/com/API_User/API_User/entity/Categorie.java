package com.API_User.API_User.entity;
import com.API_User.API_User.dto.SousCategorieDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie {


    @Id
    @Column(name="code_categorie", length = 45)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorie_generator")
    private int id;

    @Column(name="Nom_categorie", length = 255)
    private String nom_categorie;


    public Categorie(int code_categorie, String nom_categorie) {
        this.id = code_categorie;
        this.nom_categorie = nom_categorie;
    }

    public Categorie() {

    }




    // getters and setters

    public int getCode_categorie() {
        return id;
    }

    public void setCode_categorie(int code_categorie) {
        this.id = code_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

}