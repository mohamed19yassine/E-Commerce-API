package com.API_User.API_User.repository;



import com.API_User.API_User.entity.Categorie;
import com.API_User.API_User.entity.Commande;
import com.API_User.API_User.entity.LigneCommande;
import com.API_User.API_User.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {
    //List<Categorie> findByNom_categorie(String i);

    @Query("SELECT lc from LigneCommande lc where lc.produit.code_produit =?1")
    List<LigneCommande> findByProduitId(int i);



/*
    @Modifying
    @Query("delete from LigneCommande p where p.commande.code_commande = ?1")
    void deleteByCommandeId(int i);
*/
    //  @Modifying
    //@Query("delete from User where firstName = :firstName")
    //void deleteUsersByFirstName(@Param("firstName") String firstName);




}