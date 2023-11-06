package com.API_User.API_User.dto;

public class ProduitDTO {

    private int ref_prod;
    private String designation;
    private String description ;
    private  double prix;
    private String image;
    private int qte_stocke;

    public ProduitDTO(int ref_prod, String designation, String description, double prix, String image, int qte_stocke) {
        this.ref_prod = ref_prod;
        this.designation = designation;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.qte_stocke = qte_stocke;
    }

    public int getRef_prod() {
        return ref_prod;
    }

    public void setRef_prod(int ref_prod) {
        this.ref_prod = ref_prod;
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
}
