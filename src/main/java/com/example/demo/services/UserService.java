package com.example.demo.services;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.demo.model.User;
import com.example.demo.repositoryDAO.UserRepository;
 
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
 
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public List<User> findUsersByPosteId(Long id_poste) {
        return userRepository.findUsersByPosteId(id_poste);
    }
}