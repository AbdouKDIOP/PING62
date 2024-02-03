package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Domain;
import com.example.demo.repositoryDAO.DomainRepository;

@Service
public class DomainService {
	private final DomainRepository domaineRepository;

    @Autowired
    public DomainService(DomainRepository domaineRepository) {
        this.domaineRepository = domaineRepository;
    }

	// Méthode pour récupérer tous les produits depuis la BDD
	 public List<Domain> getAllDomains() {
	     return domaineRepository.findAll();
	 }
	 
	 public Domain getDomainByIdDomain(Long id_domain) {
	        return domaineRepository.findByIdDomain(id_domain);
	    }
}