package com.API_User.API_User.repository;



import com.API_User.API_User.entity.Categorie;
import com.API_User.API_User.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    //List<Categorie> findByNom_categorie(String i);




}