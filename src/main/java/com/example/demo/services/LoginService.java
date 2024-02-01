package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.model.User;
import com.example.demo.repositoryDAO.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {
	@Autowired
    private UserRepository userRepository;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean checkLogin(String username, String password) {
        User user = userRepository.findByEmail(username);

        // Vérifier si l'utilisateur existe et le statut est actif (statusUser = 1)
        if (user != null && user.getStatusUser() == 1 && passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("User found in the database: " + user);
            System.out.println("Login successful for user: " + user.getEmail());
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            session.setAttribute("loggedInUser", user);
            return true;
        } else {
        	if (user == null) {
                System.out.println("Login failed. User not found for username: " + username);
            } else if (user.getStatusUser() != 1) {
                System.out.println("Login failed. User is inactive");
            } else {
                System.out.println("Login failed.");
            }
            return false;
        }
    }
}
