package com.example.demo.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repositoryDAO.UserRepository;

@Service
public class SignUpService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public SignUpService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void registerUser(User user) {
        String motDePasseCrypte = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(motDePasseCrypte);
        user.setStatusUser(0);
        userRepository.save(user);
    }
}
