package com.example.demo.services;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoder {
	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String motDePasseCrypte = passwordEncoder.encode("mot_de_passe_clair");
        System.out.println(motDePasseCrypte);
	}
}
