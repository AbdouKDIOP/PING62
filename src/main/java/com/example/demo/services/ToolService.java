package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Tool;
import com.example.demo.repositoryDAO.ToolRepository;

@Service
public class ToolService {
	private final ToolRepository toolRepository;
	
	public ToolService(ToolRepository toolRepository) {
	     this.toolRepository = toolRepository;
	 }

	// Méthode pour récupérer tous les produits depuis la BDD
	 public List<Tool> getAllTool() {
	     return toolRepository.findAll();
	 }
	 
	 public Tool getToolById(Long id) {
	        return toolRepository.findByIdTool(id);
	    }
}