package com.example.demo.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Source;
import com.example.demo.repositoryDAO.SourceRepository;

@Service
public class SourceService {

    private final SourceRepository sourceRepository;
    
    public SourceService(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    // Méthode pour récupérer tous les produits depuis la BDD
    public List<Source> getAllSource() {
        return sourceRepository.findAll();
    }
    
    public Source getSourceById(Long id) {
        return sourceRepository.findByIdSource(id);
    }

    // Méthode pour sauvegarder ou mettre à jour une source dans la BDD
    public void save(Source source) {
        sourceRepository.save(source);
    }
}
