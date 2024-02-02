package com.example.demo;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosteService {
    
    @Autowired
    private PosteRepository posteRepository;

    public List<Poste> findAll() {
        return posteRepository.findAll();
    }
}
