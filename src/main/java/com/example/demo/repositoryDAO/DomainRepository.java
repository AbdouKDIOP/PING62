package com.example.demo.repositoryDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Domaine;

public interface DomainRepository extends JpaRepository<Domaine, Long> {
	Domaine findByIdDomain(Long id_domain);
}