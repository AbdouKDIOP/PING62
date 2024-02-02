package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Workspace;
import com.example.demo.repositoryDAO.WorkspaceRepository;

@Service
public class WorkspaceService {
	private final WorkspaceRepository workspaceRepository;
	
	public WorkspaceService(WorkspaceRepository workspaceRepository) {
	     this.workspaceRepository = workspaceRepository;
	 }

	// Méthode pour récupérer tous les produits depuis la BDD
	 public List<Workspace> getAllWorkspace() {
	     return workspaceRepository.findAll();
	 }
	 
	 public Workspace getWorkspaceById(Long id) {
	        return workspaceRepository.findByIdWorkspace(id);
	    }
}