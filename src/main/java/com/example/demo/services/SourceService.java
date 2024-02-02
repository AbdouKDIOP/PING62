package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.Source;
import org.springframework.stereotype.Service;

import com.example.demo.repositoryDAO.SourceRepository;

import java.util.List;

@Service
public class SourceService {
	@Autowired
    private final SourceRepository sourceRepository;

    
    public SourceService(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    public List<Source> getAllSources() {
        return sourceRepository.findAll();
    }
}
