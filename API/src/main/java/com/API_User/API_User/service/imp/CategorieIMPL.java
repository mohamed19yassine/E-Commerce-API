package com.API_User.API_User.service.imp;


import com.API_User.API_User.dto.CategorieDTO;
import com.API_User.API_User.dto.ClientDTO;
import com.API_User.API_User.dto.LoginDTO;
import com.API_User.API_User.entity.Categorie;
import com.API_User.API_User.entity.Client;
import com.API_User.API_User.exception.ResourceNotFoundException;
import com.API_User.API_User.repository.CategorieRepository;
import com.API_User.API_User.repository.ClientRepo;
import com.API_User.API_User.response.LoginResponse;
import com.API_User.API_User.service.CategorieService;
import com.API_User.API_User.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieIMPL {

    @Autowired
    private CategorieRepository categorieRepository;




}
