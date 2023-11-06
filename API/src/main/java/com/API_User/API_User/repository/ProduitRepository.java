package com.API_User.API_User.repository;



import com.API_User.API_User.entity.Produit;
import com.API_User.API_User.entity.Souscategorie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {

   // List<Comment> findByTutorialId(Long postId);


    @Query("SELECT p from Produit p where p.souscategorie.code_souscategorie =?1")
   List<Produit> findBySouscategorieId(int i);

    // @Transactional
    //void deleteByTutorialId(long tutorialId);
   // void deleteByProduitId(int categorieId);
}