package com.API_User.API_User.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="client")
public class Client {


    @Id
    @Column(name="code_client", length = 45)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
    private int code_client;

    @Column(name="client_name", length = 255)
    private String client_name;

    @Column(name="prenom_client", length = 255)
    private String prenom_client;

    @Column(name="email", length = 255)
    private String email;

    @Column(name="adresse", length = 255)
    private String adresse;

    @Column(name="photo", length = 255)
    private String photo;


    @Column(name="tel", length = 45)
    private int tel;

    @Column(name="username", length = 255)
    private String username;

    @Column(name="password", length = 255)
    private String password;

    @Column(name="date_creation_compte", length = 255)
    private String date_creation_compte;

    @Column(name="ville", length = 255)
    private String ville;


    public Client(int code_client, String client_name, String prenom_client, String email, String adresse, String photo, int tel, String username, String password, String date_creation_compte, String ville) {
        this.code_client = code_client;
        this.client_name = client_name;
        this.prenom_client = prenom_client;
        this.email = email;
        this.adresse = adresse;
        this.photo = photo;
        this.tel = tel;
        this.username = username;
        this.password = password;
        this.date_creation_compte = date_creation_compte;
        this.ville = ville;
    }

    public Client() {

    }

    public int getCode_client() {
        return code_client;
    }

    public void setCode_client(int code_client) {
        this.code_client = code_client;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate_creation_compte() {
        return date_creation_compte;
    }

    public void setDate_creation_compte(String date_creation_compte) {
        this.date_creation_compte = date_creation_compte;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
