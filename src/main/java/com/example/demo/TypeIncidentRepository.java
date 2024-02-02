package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeIncidentRepository extends JpaRepository<TypeIncident, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
}
