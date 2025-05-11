package com.example.sosialhub_project.repository;

import com.example.sosialhub_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //Finn bruker basert på brukernavn
    Optional<User> findByUsername(String username);

    //Finn bruker baser på e-post
    Optional<User> findByEmail(String email);

    //Sjekk om brukernavn allerede finnes
    boolean existsByUsername(String username);

    //Sjekk om e-post allerede finnes
    boolean existsByEmail(String email);
}
