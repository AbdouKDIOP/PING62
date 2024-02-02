
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String username);
    // Ici, vous pouvez définir des méthodes personnalisées si nécessaire

}
