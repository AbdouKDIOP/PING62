package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TypeIncident;

@Repository
public interface TypeIncidentRepository extends JpaRepository<TypeIncident, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
}
