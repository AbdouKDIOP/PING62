package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Poste;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
