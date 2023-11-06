package com.API_User.API_User.dto;

import java.util.ArrayList;
import java.util.List;

public class CategorieDTO {
    private List<SousCategorieDTO> sousCategorieDTOs;
    private int code_categorie;
    private String nom_categorie;

    public List<SousCategorieDTO> getSousCategorieDTOs() {
        return sousCategorieDTOs;
    }

    public void setSousCategorieDTOs(List<SousCategorieDTO> sousCategorieDTOs) {
        this.sousCategorieDTOs = sousCategorieDTOs;
    }

    public int getCode_categorie() {
        return code_categorie;
    }

    public void setCode_categorie(int code_categorie) {
        this.code_categorie = code_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public CategorieDTO(int code_categorie, String nom_categorie) {
        this.code_categorie = code_categorie;
        this.nom_categorie = nom_categorie;
        this.sousCategorieDTOs=new ArrayList<SousCategorieDTO>();
    }

    public void addSousCategorieDTOs(SousCategorieDTO sousCategorieDTO) {
        sousCategorieDTOs.add(sousCategorieDTO);
    }
    public void remouveSousCategorieDTOs(SousCategorieDTO sousCategorieDTO) {
        sousCategorieDTOs.remove(sousCategorieDTO);
    }

}
