package com.API_User.API_User.dto;

public class ClientDTO {



    private int client_id;

    private String client_name;

    private String prenom_client;

    private String email;

    private String adresse;

    private String photo;
    private int tel;

    private String username;

    private String password;

    private String date_creation_compte;

    private String ville;

    public ClientDTO(int client_id, String client_name, String prenom_client, String email, String adresse, String photo, int tel, String username, String password, String date_creation_compte, String ville) {
        this.client_id = client_id;
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

    public ClientDTO() {
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
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

    @Override
    public String toString() {
        return "ClientDTO{" +
                "client_id=" + client_id +
                ", client_name='" + client_name + '\'' +
                ", prenom_client='" + prenom_client + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", photo='" + photo + '\'' +
                ", tel=" + tel +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", date_creation_compte='" + date_creation_compte + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
