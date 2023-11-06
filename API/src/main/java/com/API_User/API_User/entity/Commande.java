package com.API_User.API_User.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @Column(name="code_commande", length = 45)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commande_generator")
    private int code_commande;

    @Column(name="date_commande", length = 255)
    private String date_commande;

    @Column(name="etat_commande", length = 255)
    private String etat_commande;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Client client;


    public int getCode_commande() {
        return code_commande;
    }

    public void setCode_commande(int code_commande) {
        this.code_commande = code_commande;
    }

    public String getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(String date_commande) {
        this.date_commande = date_commande;
    }

    public String getEtat_commande() {
        return etat_commande;
    }

    public void setEtat_commande(String etat_commande) {
        this.etat_commande = etat_commande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}