package com.example.demo.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Dataset;
import com.example.demo.model.Workspace;
import com.example.demo.repositoryDAO.DatasetRepository;
import com.example.demo.repositoryDAO.WorkspaceRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    @Autowired
    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public List<Workspace> getAllWorkspaces() {
        return workspaceRepository.findAll();
    }

    public Optional<Workspace> findWorkspaceById(Long id) {
        return workspaceRepository.findById(id);
    }

    public Workspace saveWorkspace(Workspace workspace) {
        return workspaceRepository.save(workspace);
    }

    // Vous pouvez ajouter d'autres méthodes pour gérer les opérations sur les
    // workspaces
}
