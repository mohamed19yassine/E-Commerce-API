package com.API_User.API_User.repository;



import com.API_User.API_User.entity.Categorie;
import com.API_User.API_User.entity.Souscategorie;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface SouscategorieRepository extends JpaRepository<Souscategorie, Integer> {

   // List<Comment> findByTutorialId(Long postId);

   List<Souscategorie> findByCategorieId(int i);

    // @Transactional
    //void deleteByTutorialId(long tutorialId);
    void deleteByCategorieId(int categorieId);

}