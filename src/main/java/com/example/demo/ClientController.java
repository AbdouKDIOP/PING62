package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	// Méthode pour le rendu de la vue Thymeleaf
	@GetMapping("/clients")
	public String listClients(Model model) {
		List<Client> clients = clientService.findAll();
		model.addAttribute("clients", clients);
		return "client"; // Nom de votre template Thymeleaf
	}

	// Méthode REST pour obtenir les clients en format JSON
	@GetMapping("/api/clients")
	@ResponseBody
	public List<Client> listClientsRest() {
		return clientService.findAll();
	}
}
