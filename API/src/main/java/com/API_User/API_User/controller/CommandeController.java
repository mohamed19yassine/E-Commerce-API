package com.API_User.API_User.controller;


import com.API_User.API_User.entity.Client;
import com.API_User.API_User.entity.Commande;
import com.API_User.API_User.entity.Souscategorie;
import com.API_User.API_User.exception.ResourceNotFoundException;
import com.API_User.API_User.repository.CategorieRepository;
import com.API_User.API_User.repository.ClientRepo;
import com.API_User.API_User.repository.CommandeRepository;
import com.API_User.API_User.repository.SouscategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/commande")
public class CommandeController {


    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientRepo clientRepo;


    @GetMapping("/clients/{clientId}/Commande")
    public ResponseEntity<List<Commande>> getAllCommandesByClientId(@PathVariable(value = "clientId") int clientId) {
        if (!clientRepo.existsById(clientId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + clientId);
        }

        List<Commande> commandes = commandeRepository.findByClientID(clientId);
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }
    @GetMapping("/commande/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable(value = "id") int id) {
        Commande comment = commandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + id));

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/client/{clientId}/commandes")
    public ResponseEntity<Commande> createCommande(@PathVariable(value = "clientId") int clientId,
                                                 @RequestBody Commande sc) {
        Commande commande = clientRepo.findById(clientId).map(client -> {
            sc.setClient(client);
            return commandeRepository.save(sc);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + clientId));

        return new ResponseEntity<>(sc, HttpStatus.CREATED);
    }



/*
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
    }*/

}