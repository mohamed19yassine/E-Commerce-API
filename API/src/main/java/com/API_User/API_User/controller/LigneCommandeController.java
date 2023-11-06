package com.API_User.API_User.controller;


import com.API_User.API_User.entity.Commande;
import com.API_User.API_User.entity.LigneCommande;
import com.API_User.API_User.entity.Produit;
import com.API_User.API_User.entity.Souscategorie;
import com.API_User.API_User.exception.ResourceNotFoundException;
import com.API_User.API_User.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/SousCategorie")
public class LigneCommandeController {



    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    //    categories categories Produit produit  ------SousCategorie sousCategorie LigneCommand ligneCommand

    @GetMapping("/produits/{produitId}/sousCategories")
    public ResponseEntity<List<LigneCommande>> getAllLigneCommandesByProduitId(@PathVariable(value = "produitId") int produitId) {
        if (!produitRepository.existsById(produitId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + produitId);
        }

        List<LigneCommande> comments = ligneCommandeRepository.findByProduitId(produitId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/ligneCommands/{id}")
    public ResponseEntity<LigneCommande> getLigneCommandesById(@PathVariable(value = "id") int id) {
        LigneCommande ligneCommande = ligneCommandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + id));

        return new ResponseEntity<>(ligneCommande, HttpStatus.OK);
    }


    @PostMapping("/produits/{commandeId}/{produitId}/ligneCommands")
    public ResponseEntity<LigneCommande> createLigneCommande(@PathVariable(value = "commandeId") int commandeId,
                                                             @PathVariable(value = "produitId") int produitId,
                                                             @RequestBody LigneCommande lc) {
        Commande comment = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + commandeId));
      //  Produit produits = produitRepository.findById(produitId)
        //        .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + produitId));

        lc.setCommande(comment);
        //lc.setProduit(produits);
       // ligneCommandeRepository.save(lc);


        LigneCommande ligneCommande = produitRepository.findById(produitId).map(produit -> {
            lc.setProduit(produit);
            return ligneCommandeRepository.save(lc);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + produitId));

        return new ResponseEntity<>(ligneCommande, HttpStatus.CREATED);
    }




    @DeleteMapping("/ligneCommands/{id}")
    public ResponseEntity<HttpStatus> deleteligneCommands(@PathVariable("id") int id) {
        ligneCommandeRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
/*
    @DeleteMapping("/commande/{commandeId}/ligneCommands")
    public ResponseEntity<HttpStatus> deleteAlligneCommandsOfcommande(@PathVariable(value = "commandeId") int commandeId) {
        if (!produitRepository.existsById(commandeId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + commandeId);
        }

        ligneCommandeRepository.deleteByCommandeId(commandeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

 */

}