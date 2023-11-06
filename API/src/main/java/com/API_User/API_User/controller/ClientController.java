package com.API_User.API_User.controller;



import com.API_User.API_User.dto.ClientDTO;
import com.API_User.API_User.dto.LoginDTO;
import com.API_User.API_User.entity.Client;
import com.API_User.API_User.response.LoginResponse;
import com.API_User.API_User.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping ("api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public List<Client> getAllUser(){
        return clientService.getClients();

    }
    @PostMapping(path="/save")
    public String saveClient(@RequestBody ClientDTO clientDTO){
         String name = clientService.addClient(clientDTO);
        return name;

    }
    @PostMapping(path="/login")
    public ResponseEntity<?>loginClient(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse=clientService.loginClient(loginDTO);
       return ResponseEntity.ok(loginResponse);
    }


//-------------------les tests----------------------

    @GetMapping(path="/test1")
    public String saveEmployee1(){
        System.out.println("ok");
        String id = "aaaa";
        return id;

    }

    @PostMapping(path="/test2")
    public String saveEmployee2(@RequestBody  ClientDTO clientDTO){
        String i=clientDTO.toString();
        return i;

    }

    @PostMapping(path="/test3")
    public String savePerson(@RequestBody  Person clientDTO){
        String i=clientDTO.toString();
        return i;

    }

}
