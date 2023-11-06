package com.API_User.API_User.controller;



import com.API_User.API_User.dto.CategorieDTO;
import com.API_User.API_User.entity.Categorie;

import com.API_User.API_User.exception.ResourceNotFoundException;
import com.API_User.API_User.repository.CategorieRepository;
import com.API_User.API_User.repository.SouscategorieRepository;
import com.API_User.API_User.service.CategorieService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
    private CategorieRepository categorieRepository;

// Categorie
    @GetMapping("/categorie")
    public ResponseEntity<List<Categorie>> getAllCategories() {
        List<Categorie> categories = new ArrayList<Categorie>();


            categorieRepository.findAll().forEach(categories::add);

        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable("id") int id) {
        Categorie tutorial = categorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        Categorie _tutorial = categorieRepository.save(new Categorie(categorie.getCode_categorie(), categorie.getNom_categorie()));
        return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
    }
    @PutMapping("/categories/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable("id") int id, @RequestBody Categorie tutorial) {
        Categorie _categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

        _categorie.setNom_categorie(tutorial.getNom_categorie());


        return new ResponseEntity<>(categorieRepository.save(_categorie), HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<HttpStatus> deleteCategorie(@PathVariable("id") int id) {
        categorieRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/categories")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        categorieRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}