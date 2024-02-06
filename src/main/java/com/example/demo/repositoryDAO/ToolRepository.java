package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tool;

public interface ToolRepository extends JpaRepository<Tool, Long>{
	Tool findByIdTool(Long id_tool);
}
