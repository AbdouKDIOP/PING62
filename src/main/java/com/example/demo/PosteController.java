package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Poste;
import com.example.demo.services.PosteService;
import com.example.demo.repositoryDAO.PosteRepository;

@Controller
public class PosteController {

	@Autowired
	private PosteService posteService;

	@GetMapping("/postes")
	public String listPostes(Model model) {
		List<Poste> postes = posteService.findAll();
		model.addAttribute("postes", postes);
		return "contactezNous"; // Nom de votre template Thymeleaf
	}
}
