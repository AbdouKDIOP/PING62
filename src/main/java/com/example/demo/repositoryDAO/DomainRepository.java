package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Domain;

public interface DomainRepository extends JpaRepository<Domain, Long> {
    Domain findByIdDomain(Long id_domain);
}