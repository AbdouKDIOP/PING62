package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repositoryDAO.UserRepository;

import jakarta.transaction.Transactional;
@Service
public class UserService {
	
	private final UserRepository userRepository;
		
	public UserService(UserRepository userRepository) {
	     this.userRepository = userRepository;
	 }
	
	public User getUserById(Long id) {
        return userRepository.findByIdUser(id);
    }
	
	public List<User> getAllUser() {
        return userRepository.findAll();
    }
	
	public List<User> findUsersByPosteId(Long id_poste) {
        return userRepository.findUsersByPosteId(id_poste);
    }
	
	@Transactional
    public void updateAccountStatus(Long userId, int newStatus) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setStatusUser(newStatus);
            userRepository.save(user);
        }
    }
	
	@Transactional
    public void saveOrUpdateUser(User user) {
        userRepository.save(user);
    }
}
