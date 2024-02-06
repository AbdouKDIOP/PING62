package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Poste;

public interface PostRepository extends JpaRepository<Poste, Long> {
	Poste findByIdPoste(Long id_poste);
}
