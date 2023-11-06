package com.API_User.API_User.controller;


import com.API_User.API_User.entity.Souscategorie;
import com.API_User.API_User.exception.ResourceNotFoundException;
import com.API_User.API_User.repository.CategorieRepository;

import com.API_User.API_User.repository.SouscategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/SousCategorie")
public class SousCategorieController {


    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private SouscategorieRepository souscategorieRepository;

    //    Categorie categorie tutorials ------SousCategorie sousCategorie Comment

    @GetMapping("/categories/{categorieId}/sousCategories")
    public ResponseEntity<List<Souscategorie>> getAllSousCategoriesByCategorieId(@PathVariable(value = "categorieId") int categorieId) {
        if (!categorieRepository.existsById(categorieId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + categorieId);
        }

        List<Souscategorie> comments = souscategorieRepository.findByCategorieId(categorieId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/sousCategories/{id}")
    public ResponseEntity<Souscategorie> getSousCategoriesById(@PathVariable(value = "id") int id) {
        Souscategorie comment = souscategorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + id));

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }


    @PostMapping("/categories/{categorieId}/sousCategories")
    public ResponseEntity<Souscategorie> createSousCategorie(@PathVariable(value = "categorieId") int categorieId,
                                                 @RequestBody Souscategorie sc) {
        Souscategorie sousCategorie = categorieRepository.findById(categorieId).map(categorie -> {
            sc.setCategorie(categorie);
            return souscategorieRepository.save(sc);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + categorieId));

        return new ResponseEntity<>(sousCategorie, HttpStatus.CREATED);
    }




    @PutMapping("/sousCategories/{id}")
    public ResponseEntity<Souscategorie> updateSousCategories(@PathVariable("id") int id, @RequestBody Souscategorie sousCategorie) {
        Souscategorie sc = souscategorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));

        sc.setNom_souscategorie(sousCategorie.getNom_souscategorie());

        return new ResponseEntity<>(souscategorieRepository.save(sousCategorie), HttpStatus.OK);
    }

    @DeleteMapping("/sousCategories/{id}")
    public ResponseEntity<HttpStatus> deleteSousCategories(@PathVariable("id") int id) {
        souscategorieRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/Categories/{CategorieId}/sousCategories")
    public ResponseEntity<List<Souscategorie>> deleteAllSousCategoriesOfCategorie(@PathVariable(value = "CategorieId") int tutorialId) {
        if (!categorieRepository.existsById(tutorialId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
        }

        souscategorieRepository.deleteByCategorieId(tutorialId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}