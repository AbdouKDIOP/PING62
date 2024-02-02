package com.example.demo;

//IncidentRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Incident;
public interface IncidentRepository extends JpaRepository<Incident, Long> {
 // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}

