package com.API_User.API_User.dto;

import com.API_User.API_User.dto.ProduitDTO;

import java.util.ArrayList;
import java.util.List;

public class SousCategorieDTO {
    private List<ProduitDTO>  produitDTOs=new ArrayList<ProduitDTO>();
    private int code_sous_categorie;
    private String nom_sous_categorie;

    public SousCategorieDTO() {

    }

    public SousCategorieDTO(int code_sous_categorie, String nom_sous_categorie) {
        this.code_sous_categorie = code_sous_categorie;
        this.nom_sous_categorie = nom_sous_categorie;
    }

    public SousCategorieDTO(int code_sous_categorie, String nom_sous_categorie, ProduitDTO produitDTO) {
        this.produitDTOs.add(produitDTO);
        this.code_sous_categorie = code_sous_categorie;
        this.nom_sous_categorie = nom_sous_categorie;
    }

    public List<ProduitDTO> getProduitDTOs() {
        return produitDTOs;
    }

    public void setProduitDTOs(List<ProduitDTO> produitDTOs) {
        this.produitDTOs = produitDTOs;
    }

    public void addProduitDTO(ProduitDTO produitDTO) {
        this.produitDTOs.add(produitDTO);
    }
    public void remouveProduitDTO(ProduitDTO produitDTO) {
        this.produitDTOs.remove(produitDTO);
    }

    public void setCode_sous_categorie(int code_sous_categorie) {
        this.code_sous_categorie = code_sous_categorie;
    }

    public void setNom_sous_categorie(String nom_sous_categorie) {
        this.nom_sous_categorie = nom_sous_categorie;
    }

    public int getCode_sous_categorie() {
        return code_sous_categorie;
    }

    public String getNom_sous_categorie() {
        return nom_sous_categorie;
    }


}
