package com.example.demo.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String username);
    // Ici, vous pouvez définir des méthodes personnalisées si nécessaire
	User findByIdUser(Long id_user);
}