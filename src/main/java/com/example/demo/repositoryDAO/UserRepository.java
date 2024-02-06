package com.example.demo.repositoryDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String username);
    // Ici, vous pouvez définir des méthodes personnalisées si nécessaire
	User findByIdUser(Long id_user);
	@Query("SELECT u FROM User u WHERE u.poste.idPoste = :id_poste")
    List<User> findUsersByPosteId(Long id_poste);
}