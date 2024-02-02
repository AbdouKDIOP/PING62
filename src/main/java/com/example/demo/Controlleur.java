package com.example.demo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Client;
import com.example.demo.model.Domaine;
import com.example.demo.model.Incident;
import com.example.demo.model.Poste;
import com.example.demo.model.TypeIncident;
import com.example.demo.model.User;






import com.example.demo.repositoryDAO.ClientRepository;
import com.example.demo.repositoryDAO.IncidentRepository;
import com.example.demo.repositoryDAO.PosteRepository;
import com.example.demo.repositoryDAO.TypeIncidentRepository;
import com.example.demo.repositoryDAO.UserRepository;

import com.example.demo.services.ClientService;
import com.example.demo.services.IncidentService;
import com.example.demo.services.PosteService;
import com.example.demo.services.TypeIncidentService;





import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping({""})
public class Controlleur {
	@GetMapping({"/about"})
	   public String about() {
	      return "about";
	   }

	   @GetMapping({"/accueil"})
	   public String accueil() {
	      return "accueil";
	   }

	   @GetMapping({"/actualite"})
	   public String actualite() {
	      return "actualite";
	   }

	   @GetMapping({"/add_incident"})
	   public String add_incident() {
	      return "add_incidence";
	   }
	   
	   
	   
	   @Autowired
	    private IncidentRepository incidentRepository;
	   
	   @PostMapping("/ajouter-incident")
	   public String ajouterIncident(@RequestParam("date_incident") Date date_incident,
	                                 @RequestParam("title_incident") String title_incident,
	                                 @RequestParam("description_incident") String description_incident,
	                                 @RequestParam("status") String status) throws java.text.ParseException {

	       // Créer une nouvelle instance d'Incident
	       Incident incident = new Incident();

	       
	           // Convertir la chaîne de date en objet Date
	           /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	           Date dateIncident = (Date) sdf.parse(date_incident);*/
	           incident.setDate_incident(date_incident);
	       

	       // Autres attributs de l'incident
	       incident.setTitle_incident(title_incident);
	       incident.setDescription_incident(description_incident);
	       incident.setIs_activated("actif".equals(status)); // Assurez-vous que le statut est correctement interprété
	       //incident.SetId_typeincident(id_typeincident);
	       // Enregistrement de l'incident dans la base de données
	       incidentRepository.save(incident);

	       // Rediriger vers la page d'administration des incidents
	       return "redirect:/incidentAdmin";
	   }
	  
	   @PostMapping(path ="/update_incident", consumes = MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<?> updateIncident(@RequestBody Incident updatedIncident) {
		   	System.out.println(updatedIncident);
		    try {
		        Long incidentId = updatedIncident.getId_incident(); // L'indice 0 représente l'ID de l'incident
		        System.out.println("Données reçues du frontend id: " + incidentId);
		        Optional<Incident> optionalIncident = incidentRepository.findById(5L);
		        System.out.println("Données reçues du frontend objet: " + updatedIncident);
		        

		        if (optionalIncident.isPresent()) {
		            Incident incident = optionalIncident.get();
		            
		            
		           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		            // Mettez à jour les propriétés de l'incident avec les nouvelles valeurs de la carte updatedincident
		            incident.setDate_incident(updatedIncident.getDate_incident()); // Assurez-vous que la conversion de la date est correcte
		            incident.setTitle_incident(updatedIncident.getTitle_incident());
		            incident.setDescription_incident(updatedIncident.getDescription_incident());

		            // Convertit "Actif" en true et "Inactif" en false
		            incident.setIs_activated("1".equals(updatedIncident.getIs_activated()));

		           incidentRepository.save(incident);

		            // Vous pouvez également retourner l'incident mis à jour si nécessaire
		            return ResponseEntity.ok(updatedIncident.getDate_incident());
		        } else {
		           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Incident non trouvé");
		        }
		    } catch (Exception e) {
		    	System.out.println(e);
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour de l'incident");
		    }
		}

	  
	   @GetMapping({"/datasetAdmin"})
	   public String datasetAdmin() {
	      return "datasetAdmin";
	   }
	   
	   
	   @GetMapping({"/client"})
	   public String listClients(Model model) {
	        return "client"; // Nom de votre template Thymeleaf
	    }

	   @GetMapping({"/clientAdmin"})
	   public String clientAdmin() {
	      return "clientAdmin";
	   }

	   @GetMapping({"/clientRuche"})
	   public String clientRuche() {
	      return "clientRuche";
	   }

	   @GetMapping({"/contact2"})
	   public String contact2() {
	      return "contact2";
	   }

	   @GetMapping({"/contactezNous"})
	   public String contactezNous() {
	      return "contactezNous";
	   }

	   @GetMapping({"/dataset"})
	   public String dataset() {
	      return "dataset";
	   }

	   @GetMapping({"/domaine"})
	   public String domaine() {
	      return "domaine";
	   }

	   @GetMapping({"/essai"})
	   public String essai() {
	      return "essai";
	   }

	   @GetMapping({"/headerAdmin"})
	   public String headerAdmin() {
	      return "headerAdmin";
	   }

	   @GetMapping({"/headerUserFSP"})
	   public String headerUserFSP() {
	      return "headerUserFSP";
	   }

	   @GetMapping({"/headerUserRuche"})
	   public String headerUserRuche() {
	      return "headerUserRuche";
	   }

	   @GetMapping({"/incidentAdmin"})
	   public String incident() {
	      return "incidentAdmin";
	   }

	   @GetMapping({"/outil"})
	   public String outil() {
	      return "outil";
	   }

	   @GetMapping({"/login"})
	   public String login() {
	      return "login";
	   }

	   @GetMapping({"/produit"})
	   public String produit() {
	      return "produit";
	   }
	   @GetMapping({"/signup"})
	   public String signup() {
	      return "signup";
	   }

	   @GetMapping({"/source"})
	   public String source() {
	      return "source";
	   }

	   @GetMapping({"/sourceAdmin"})
	   public String sourceAdmin() {
	      return "sourceAdmin";
	   }

	   @GetMapping({"/sourceRuche"})
	   public String sourceRuche() {
	      return "sourceRuche";
	   }

	   @GetMapping({"/headerc"})
	   public String headerc() {
	      return "headerConnect";
	   }

	   @GetMapping({"/headerNc"})
	   public String headerNc() {
	      return "headerNonConnect";
	   }

	   @GetMapping({"/mdpOublier"})
	   public String mdpOublier() {
	      return "mdpOublier";
	   }

	   @GetMapping({"/mdpChanger"})
	   public String mdpChanger() {
	      return "mdpChanged";
	   }

	   @GetMapping({"/datasetRuche"})
	   public String datasetRuche() {
	      return "datasetRuche";
	   }

	   @GetMapping({"/produitAdmin"})
	   public String produitAdmin() {
	      return "produitAdmin";
	   }

	   @GetMapping({"/produitRuche"})
	   public String produitRuche() {
	      return "produitRuche";
	   }

	   @GetMapping({"/incidentRuche"})
	   public String incidentRuche() {
	      return "incidentRuche";
	   }

	   @GetMapping({"/footer"})
	   public String footer() {
	      return "footer";
	   }
	}
