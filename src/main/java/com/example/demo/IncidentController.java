
package com.example.demo;

import java.util.List;


//IncidentController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class IncidentController {
 private final IncidentService incidentService;
 private IncidentRepository incidentRepository;
 @Autowired
 public IncidentController(IncidentService incidentService) {
     this.incidentService = incidentService;
 }

 @GetMapping("/incidents")
 public String getAllIncidents(Model model) {
     model.addAttribute("incidents", incidentService.getAllIncidents());
     return "incidentAdmin";
 }
 // Vous pouvez ajouter d'autres méthodes du contrôleur en fonction de vos besoins

}



