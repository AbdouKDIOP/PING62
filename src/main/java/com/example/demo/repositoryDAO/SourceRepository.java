package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Source;

public interface SourceRepository extends JpaRepository<Source, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
