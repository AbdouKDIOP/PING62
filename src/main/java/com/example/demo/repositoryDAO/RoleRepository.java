package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Poste;
import com.example.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByIdRole(Long id_role);
}
