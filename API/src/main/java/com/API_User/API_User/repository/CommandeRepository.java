package com.API_User.API_User.repository;



import com.API_User.API_User.entity.Commande;
import com.API_User.API_User.entity.LigneCommande;
import com.API_User.API_User.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    //List<Categorie> findByNom_categorie(String i);

    @Query("SELECT p from Commande p where p.client.code_client =?1")
    List<Commande> findByClientID(int i);




}