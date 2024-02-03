package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repositoryDAO.UserRepository;
@Service
public class UserService {
	
	private final UserRepository userRepository;
		
	public UserService(UserRepository userRepository) {
	     this.userRepository = userRepository;
	 }
	
	public User getUserById(Long id) {
        return userRepository.findByIdUser(id);
    }
}