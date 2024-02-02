package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Workspace;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long>{
	Workspace findByIdWorkspace(Long id_workspace);
}