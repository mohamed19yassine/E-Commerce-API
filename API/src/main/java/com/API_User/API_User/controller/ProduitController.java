package com.API_User.API_User.controller;


import com.API_User.API_User.entity.Produit;
import com.API_User.API_User.entity.Souscategorie;
import com.API_User.API_User.exception.ResourceNotFoundException;
import com.API_User.API_User.repository.CategorieRepository;
import com.API_User.API_User.repository.ProduitRepository;
import com.API_User.API_User.repository.SouscategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/SousCategorie")
public class ProduitController {


    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private SouscategorieRepository sousctegorieRepository;

    //    Categorie categorie SousCategorie sousCategorie------SousCategorie sousCategorie  Produit produit

    @GetMapping("/produits")
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = produitRepository.findAll();


        return new ResponseEntity<>(produits, HttpStatus.OK);
    }



    @GetMapping("/sousCategories/{sousCategorieId}/produits")
    public ResponseEntity<List<Produit>> getAllproduitsBySousCategorieId(@PathVariable(value = "sousCategorieId") int sousCategorieId) {
        if (!produitRepository.existsById(sousCategorieId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + sousCategorieId);
        }
                                                   //findByCategorieId
        List<Produit> produits = produitRepository.findBySouscategorieId(sousCategorieId);
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @GetMapping("/produits/{id}")
    public ResponseEntity<Produit> getProduitsById(@PathVariable(value = "id") int id) {
        Produit produits = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + id));

        return new ResponseEntity<>(produits, HttpStatus.OK);
    }







    @PostMapping("/sousCategories/{sousCategorieId}/produits")
    public ResponseEntity<Produit> createProduit(@PathVariable(value = "sousCategorieId") int sousCategorieId,
                                                 @RequestBody Produit produits) {
        Produit produit = sousctegorieRepository.findById(sousCategorieId).map(sousCategorie -> {
            produits.setSouscategorie(sousCategorie);
            return produitRepository.save(produits);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + sousCategorieId));

        return new ResponseEntity<>(produits, HttpStatus.CREATED);
    }


/*

    @PutMapping("/sousCategories/{id}")
    public ResponseEntity<SousCategorie> updateSousCategories(@PathVariable("id") int id, @RequestBody SousCategorie sousCategorie) {
        SousCategorie sc = sousCategorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));

        sc.setNom_sous_categorie(sousCategorie.getNom_sous_categorie());

        return new ResponseEntity<>(sousCategorieRepository.save(sousCategorie), HttpStatus.OK);
    }

    @DeleteMapping("/sousCategories/{id}")
    public ResponseEntity<HttpStatus> deleteSousCategories(@PathVariable("id") int id) {
        sousCategorieRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/Categories/{CategorieId}/sousCategories")
    public ResponseEntity<List<SousCategorie>> deleteAllSousCategoriesOfCategorie(@PathVariable(value = "CategorieId") int tutorialId) {
        if (!categorieRepository.existsById(tutorialId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
        }

        sousCategorieRepository.deleteByCategorieId(tutorialId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

}