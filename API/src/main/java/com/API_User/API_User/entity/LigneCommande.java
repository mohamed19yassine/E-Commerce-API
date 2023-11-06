package com.API_User.API_User.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "ligneCommande")
public class LigneCommande {

    @Id
    @Column(name="code_ligneCommande", length = 45)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ligneCommande_generator")
    private int code_ligneCommande;

    @Column(name="quantite", length = 255)
    private int quantite;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "produit_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Produit produit;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "commande_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Commande commande;

    public LigneCommande() {
    }

    public int getCode_ligneCommande() {
        return code_ligneCommande;
    }

    public void setCode_ligneCommande(int code_ligneCommande) {
        this.code_ligneCommande = code_ligneCommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public LigneCommande(int code_ligneCommande, int quantite, Produit produit) {
        this.code_ligneCommande = code_ligneCommande;
        this.quantite = quantite;
        this.produit = produit;
    }
}