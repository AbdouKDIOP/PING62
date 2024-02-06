package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Méthodes personnalisées, si nécessaire
}
