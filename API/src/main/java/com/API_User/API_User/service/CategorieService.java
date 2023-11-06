package com.API_User.API_User.service;


import com.API_User.API_User.dto.CategorieDTO;
import com.API_User.API_User.dto.ClientDTO;
import com.API_User.API_User.dto.LoginDTO;
import com.API_User.API_User.entity.Categorie;
import com.API_User.API_User.response.LoginResponse;

import java.util.List;

public interface CategorieService {

    String addCategorie(CategorieDTO categorieDTO);
    List<Categorie> getCategories(int id);



}
