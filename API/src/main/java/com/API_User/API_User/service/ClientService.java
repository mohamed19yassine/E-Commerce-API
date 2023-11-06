package com.API_User.API_User.service;


import com.API_User.API_User.dto.ClientDTO;
import com.API_User.API_User.dto.LoginDTO;
import com.API_User.API_User.entity.Categorie;
import com.API_User.API_User.entity.Client;
import com.API_User.API_User.response.LoginResponse;

import java.util.List;

public interface ClientService {

    String addClient(ClientDTO clientDTO);

    LoginResponse loginClient(LoginDTO loginDTO);

    List<Client> getClients();
}
