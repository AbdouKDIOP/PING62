package com.example.demo.repositoryDAO;
 
import java.util.List;
import org.springframework.data.jpa.repository.Query;
 
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;
 
public interface UserRepository extends JpaRepository<User, Long> {
 
	User findByEmail(String username);
    // Ici, vous pouvez définir des méthodes personnalisées si nécessaire
	//List<User> findByRole_Id(Long roleId);
	@Query("SELECT u FROM User u WHERE u.id_role = :roleId")
    List<User> findUsersByRoleId(Long roleId);
}