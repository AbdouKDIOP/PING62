package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
	 // Vous pouvez ajouter des méthodes personnalisées si nécessaire
	}