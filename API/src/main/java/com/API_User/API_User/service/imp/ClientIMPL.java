package com.API_User.API_User.service.imp;


import com.API_User.API_User.dto.ClientDTO;
import com.API_User.API_User.dto.LoginDTO;
import com.API_User.API_User.entity.Client;
import com.API_User.API_User.repository.ClientRepo;
import com.API_User.API_User.response.LoginResponse;
import com.API_User.API_User.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientIMPL implements ClientService {

    @Autowired
    private ClientRepo clientRepo;
    private PasswordEncoder passwordEncoder;
    @Override
    public String addClient(ClientDTO clientDTO) {
        Client client = new Client(



                clientDTO.getClient_id(),
                clientDTO.getClient_name(),
                clientDTO.getPrenom_client(),
                clientDTO.getEmail(),
                clientDTO.getAdresse(),
                clientDTO.getPhoto(),
                clientDTO.getTel(),
                clientDTO.getUsername(),
                clientDTO.getPassword(),
                clientDTO.getDate_creation_compte(),
                clientDTO.getVille()




        );

        clientRepo.save(client);

        return client.getClient_name();

    }

    @Override
    public LoginResponse loginClient(LoginDTO loginDTO) {


        String msg = "";
        Client employee1 = clientRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            //Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            Boolean isPwdRight = password.equals( encodedPassword);

            if (isPwdRight) {
                Optional<Client> employee = clientRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exits", false);
        }



    }

    @Override
    public List<Client> getClients() {
        return clientRepo.findAll();
    }
}
