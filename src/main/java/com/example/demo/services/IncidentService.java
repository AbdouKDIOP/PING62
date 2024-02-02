package com.example.demo.services;

//IncidentService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Incident;
import com.example.demo.repositoryDAO.IncidentRepository;

import java.util.List;

@Service
public class IncidentService {
 private final IncidentRepository incidentRepository;

 @Autowired
 public IncidentService(IncidentRepository incidentRepository) {
     this.incidentRepository = incidentRepository;
 }

 @Autowired

 public List<Incident> getAllIncidents() {
     return incidentRepository.findAll();
 }

 public void save(Incident incident) {
     // Ajoutez ici la logique de validation ou de traitement supplémentaire si nécessaire
     incidentRepository.save(incident);
 }


 }

