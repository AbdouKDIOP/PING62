package com.example.demo.services;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Poste;
import com.example.demo.repositoryDAO.PosteRepository;

@Service
public class PosteService {
    
    @Autowired
    private PosteRepository posteRepository;

    public List<Poste> findAll() {
        return posteRepository.findAll();
    }
}
