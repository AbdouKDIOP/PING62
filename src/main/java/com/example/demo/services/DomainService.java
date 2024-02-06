package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Domaine;
import com.example.demo.repositoryDAO.DomainRepository;

@Service
public class DomainService {
    private final DomainRepository domainRepository;

    @Autowired
    public DomainService(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    // Méthode pour récupérer tous les domaines depuis la BDD
    public List<Domaine> getAllDomains() {
        return domainRepository.findAll();
    }

    public Domaine getDomainByIdDomain(Long id_domain) {
        return domainRepository.findByIdDomain(id_domain);
    }
}