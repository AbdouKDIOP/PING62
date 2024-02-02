package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeIncidentService {

    private final TypeIncidentRepository typeIncidentRepository;

    @Autowired
    public TypeIncidentService(TypeIncidentRepository typeIncidentRepository) {
        this.typeIncidentRepository = typeIncidentRepository;
    }

    public List<TypeIncident> getAllTypeIncidents() {
        return typeIncidentRepository.findAll();
    }

    public TypeIncident createTypeIncident(TypeIncident typeIncident) {
        return typeIncidentRepository.save(typeIncident);
    }


    // Ajoutez d'autres méthodes selon vos besoins
}
