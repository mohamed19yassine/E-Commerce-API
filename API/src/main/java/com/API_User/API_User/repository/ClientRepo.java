package com.API_User.API_User.repository;



import com.API_User.API_User.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {

    Optional<Client> findOneByEmailAndPassword(String email, String password);

    Client findByEmail(String email);

}
