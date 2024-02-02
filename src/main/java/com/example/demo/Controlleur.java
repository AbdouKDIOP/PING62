package com.example.demo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Dataset;
import com.example.demo.model.Produit;
import com.example.demo.services.SignUpService;
import com.example.demo.services.WorkspaceService;
import com.example.demo.model.User;
import com.example.demo.model.Workspace;
import com.example.demo.repositoryDAO.DatasetRepository;
import com.example.demo.repositoryDAO.ProduitRepository;
import com.example.demo.repositoryDAO.WorkspaceRepository;
import com.example.demo.services.DatasetService;
import com.example.demo.services.LoginService;
import com.example.demo.services.LogoutService;
import com.example.demo.services.ProduitService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping({""})
public class Controlleur {
		@Autowired
		private SignUpService signUpService ;
		private ProduitService produitService ;
	    private DatasetService datasetService;
	    private final WorkspaceService workspaceService;
	    
	    @Autowired
	    private DatasetRepository datasetRepository;

	    @Autowired
	    private WorkspaceRepository workspaceRepository;
		
	    @Autowired
	    public Controlleur(SignUpService registrationService, ProduitService produitService, DatasetService datasetService,WorkspaceService workspaceService) {
	        this.signUpService = registrationService;
	        this.produitService = produitService;
	        this.datasetService = datasetService;
	        this.workspaceService = workspaceService;
	    }

		@GetMapping("/about")
		public String about(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);
	
		    return "about";
		}
	   @GetMapping("/accueil")
	   public String accueil(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);

	      return "accueil";
	   }

	   @GetMapping({"/actualite"})
	   public String actualite(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);

	      return "actualite";
	   }

		@GetMapping({"/add_incident"})
		public String add_incident(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);

		      return "add_incidence";
		}


		@GetMapping({"/datasetAdmin"})
		public String datasetAdmin(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);

		      return "datasetAdmin";
		 }


		   @GetMapping({"/client"})
		   public String client(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);

		      return "client";
		   }

		   @GetMapping({"/clientAdmin"})
		   public String clientAdmin(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);

		      return "clientAdmin";
		   }

		   @GetMapping({"/clientRuche"})
		   public String clientRuche(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);

		      return "clientRuche";
		   }

		   @GetMapping({"/contact2"})
		   public String contact2(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);

		      return "contact2";
		   }

		   @GetMapping({"/contactezNous"})
		   public String contactezNous(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);

		      return "contactezNous";
		   }
		   @GetMapping({"/dataset"})
		    public String dataset(Model model, HttpSession session) {
		        User loggedInUser = (User) session.getAttribute("loggedInUser");
		        model.addAttribute("loggedInUser", loggedInUser);

		        List<Dataset> datasets = datasetService.findAll();
		        model.addAttribute("datasets", datasets);

		        return "dataset";
		    }
		   @GetMapping({"/domaine"})
		   public String domaine(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);

		      return "domaine";
		   }



		   @GetMapping({"/headerAdmin"})
		   public String headerAdmin() {
		      return "headerConnect";
		   }

		   @GetMapping({"/headerUserFSP"})
		   public String headerUserFSP() {
		      return "headerNonConnect";
		   }

		   @GetMapping({"/headerUserRuche"})
		   public String headerUserRuche() {
		      return "headerRuche";
		   }


		   @GetMapping({"/incidentAdmin"})
		   public String incident(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);

		      return "incidentAdmin";
		   }

		   @GetMapping({"/outil"})
		   public String outil(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);

		      return "outil";
		   }

		   @GetMapping("/login")
		   public String loginPage(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);
		       return "login";
		   }


	   @GetMapping({"/signup"})
	   public String signup(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);

	      return "signup";
	   }
	   //Mapping pour l'inscription de l'utilisateur
	   @PostMapping("/registration")
	   public String processRegistration(
			    User user,
			    @RequestParam("motDePasse") String motDePasse,
			    @RequestParam("confirmMotDePasse") String confirmMotDePasse,
			    Model model,
			    @RequestParam("idPoste") String posteStr,
			    @RequestParam("statusUser") String statusStr,
			    @RequestParam("idRole") String roleStr,
			    @RequestParam("nom") String nomStr,
			    @RequestParam("prenom") String prenomStr,
			    @RequestParam("email") String emailStr,
			    @RequestParam("confirmEmail") String cemailStr,
			    @RequestParam("idDomaine") String domaine){
		   
		   		
			   if (motDePasse == null || !motDePasse.equals(confirmMotDePasse)) {
			        model.addAttribute("error", "Les mots de passe ne correspondent pas.");
			        return "signup"; // Retourne la vue du formulaire d'inscription avec un message d'erreur
			    }

			    try {
			        // Convertir les valeurs String en int
			        int poste = Integer.parseInt(posteStr);
			        int role = Integer.parseInt(roleStr);
			        int status = Integer.parseInt(statusStr);
			        int domaines = Integer.parseInt(domaine);
			        
			        user.setIdPoste(poste);
			        user.setIdRole(role);
			        user.setId_domaine(domaines);
			        user.setPassword(motDePasse);
			        user.setIdRole(role);
			        user.setNom(nomStr);
			        user.setPrenom(prenomStr);
			        user.setEmail(emailStr);
			        user.setStatusUser(status);
		

			        if (motDePasse != null) {
			            signUpService.registerUser(user);
			        }
			        return "redirect:/login?success";
			    } catch (NumberFormatException e) {
			        // Gérer l'exception si la conversion échoue
			        model.addAttribute("error", "Erreur de conversion pour les champs 'poste' ou 'role'.");
			        return "signup";
			    }
			}
	   
	   @Autowired
	   private LoginService loginService;
	   
	   @PostMapping("/connexion")
	    public String processConnexion(@RequestParam String username, @RequestParam String password, Model model) {
	        // Vérifier si l'utilisateur existe et le statut est actif (statusUser = 1)
	        boolean loginSuccess = loginService.checkLogin(username, password);

	        if (loginSuccess) {
	            // Rediriger vers la page d'accueil ou une autre page après la connexion réussie
	            return "redirect:/accueil";
	        } else {
	            // Afficher un message d'erreur sur la page de connexion
	            model.addAttribute("error", "Vos identifiant sont incorrecte");
	            return "login"; // Rediriger vers la page de connexion
	        }
	    }
	   
	   @GetMapping({"/source"})
	   public String source(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);

	      return "source";
	   }


	   @GetMapping({"/sourceAdmin"})
	   public String sourceAdmin(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);

	      return "sourceAdmin";
	   }

	   @GetMapping({"/sourceRuche"})
	   public String sourceRuche(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);

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
	   public String mdpOublier(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);

	      return "mdpOublier";
	   }

	   @GetMapping({"/mdpChanger"})
	   public String mdpChanger(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);

	      return "mdpChanged";
	   }

	   @GetMapping({"/datasetRuche"})
	   public String datasetRuche(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);

	      return "datasetRuche";
	   }

	   @GetMapping({"/produitAdmin"})
	   public String produitAdmin(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    List<Produit> produits = produitService.getAllProduits();
	        model.addAttribute("produits", produits);
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);
		    List<Dataset> datasets = datasetRepository.findAll();
		    List<Workspace> workspaces = workspaceRepository.findAll();
		    model.addAttribute("datasets", datasets);
		    model.addAttribute("workspaces", workspaces);


	      return "produitAdmin";
	   }
	   
	   @GetMapping({"/produit"})
	   public String produit(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    List<Produit> produits = produitService.getAllProduits();
	        model.addAttribute("produits", produits);
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);

	      return "produit";
	   }
	   @GetMapping({"/add_produit"})
	   public String add_produit(Model model, HttpSession session) {
	       User loggedInUser = (User) session.getAttribute("loggedInUser");
	       model.addAttribute("loggedInUser", loggedInUser);

	       // Ajouter les listes des datasets et des workspaces dans le modèle
	       List<Dataset> datasets = datasetRepository.findAll();
	       List<Workspace> workspaces = workspaceRepository.findAll();
	       model.addAttribute("datasets", datasets);
	       model.addAttribute("workspaces", workspaces);

	       return "add_produit";
	   }

	   @Autowired
	    private ProduitRepository productRepository;

	   @PostMapping("/add_produit")
	   public String ajouterProduit(HttpSession session,
	                                @RequestParam("nameProduct") String nameProduct,
	                                @RequestParam("idDataset") Long idDataset,
	                                @RequestParam("dataChampion") String dataChampion,
	                                @RequestParam("idWorkspace") Long idWorkspace,
	                                @RequestParam("summary") String summary,
	                                @RequestParam("link") String link,
	                                @RequestParam("perimeter") String perimeter,
	                                @RequestParam("featureDetails") String featureDetails) {
	       User loggedInUser = (User) session.getAttribute("loggedInUser");

	       if (loggedInUser != null) {
	           Produit product = new Produit();
	           product.setNameProduct(nameProduct);
	           product.setDataChampion(dataChampion);
	           product.setSummary(summary);
	           product.setLink(link);
	           product.setPerimeter(perimeter);
	           product.setFeatureDetails(featureDetails);

	           // Définir l'ID de l'utilisateur connecté
	           product.setIdUser(loggedInUser.getId_user());

	           // Récupérer et associer le Dataset et le Workspace
	           Dataset dataset = datasetRepository.findById(idDataset).orElse(null);
	           Workspace workspace = workspaceRepository.findById(idWorkspace).orElse(null);
	           product.setDataset(dataset);
	           product.setWorkspace(workspace);

	           productRepository.save(product);
	           return "redirect:/produitAdmin";
	       } else {
	           return "redirect:/login";
	       }
	   }

		   @GetMapping({"/produitRuche"})
		   public String produitRuche(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);

		      return "produitRuche";
		   }
		   
		   @PostMapping("/update_product")
		   public String updateProduct(HttpSession session,@RequestBody Map<String, String> updatedProduct) {
			   
			   User loggedInUser = (User) session.getAttribute("loggedInUser");
			   if (loggedInUser != null) {
		       Long productId = Long.parseLong(updatedProduct.get("id")); // Utilisation de la clé "id" pour l'ID du produit

		       Optional<Produit> optionalProduct = productRepository.findById(productId);
		       System.out.println("Données reçues du frontend : " + updatedProduct);
		       
		       if (optionalProduct.isPresent()) {
		           Produit product = optionalProduct.get();
		           
		           // Affichez les données actuelles du produit dans la console
		           System.out.println("Données actuelles du produit : ");
		           System.out.println("ID : " + product.getId()); // Utilisez le getter correspondant à l'ID
		           System.out.println("Nom du produit : " + product.getNameProduct()); // Utilisez le getter correspondant au nom du produit

		           // Mettez à jour les propriétés du produit avec les nouvelles valeurs
		           product.setNameProduct(updatedProduct.get("nameProduct")); // Nom du produit
		           
		           // Gérer la mise à jour du dataset
		           String datasetIdStr = updatedProduct.get("id_dataset");
		           if (datasetIdStr != null && !datasetIdStr.isEmpty()) {
		               Long datasetId = Long.parseLong(datasetIdStr);
		               Optional<Dataset> dataset = datasetRepository.findById(datasetId);
		               dataset.ifPresent(product::setDataset);
		           }

		           product.setDataChampion(updatedProduct.get("data_champion")); // Data Champion

		           // Gérer la mise à jour du workspace
		           String workspaceIdStr = updatedProduct.get("id_workspace");
		           if (workspaceIdStr != null && !workspaceIdStr.isEmpty()) {
		               Long workspaceId = Long.parseLong(workspaceIdStr);
		               Optional<Workspace> workspace = workspaceRepository.findById(workspaceId);
		               workspace.ifPresent(product::setWorkspace);
		           }

		           product.setSummary(updatedProduct.get("summary")); // Résumé des fonctionnalités
		           product.setLink(updatedProduct.get("link")); // Lien
		           product.setPerimeter(updatedProduct.get("perimeter")); // Périmètre
		           product.setFeatureDetails(updatedProduct.get("featureDetails")); // Détail des fonctionnalités
		           
		           // Affichez les données actuelles du produit dans la console
		           System.out.println("apres modification  : ");
		           System.out.println("ID : " + product.getId()); // Utilisez le getter correspondant à l'ID
		           System.out.println("Nom du produit : " + product.getNameProduct());

		           productRepository.save(product);


		       }
	           return "redirect:/produitAdmin";
	       } else {
	           return "redirect:/login";
	       }
	   }


		    @DeleteMapping("/delete_product/{productId}")
			   public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
			       Optional<Produit> optionalProduct = productRepository.findById(productId);

			       if (optionalProduct.isPresent()) {
			           Produit product = optionalProduct.get();
			           // Effectuez toute opération préalable à la suppression si nécessaire
			           productRepository.delete(product);
			           return ResponseEntity.ok("Produit supprimé avec succès");
			       } else {
			           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé");
			       }
			   }



	   @GetMapping({"/incidentRuche"})
	   public String incidentRuche(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);

	      return "incidentRuche";
	   }
	   


	   @GetMapping({"/footer"})
	   public String footer() {
	      return "footer";
	   }
	   

	   
	   @Autowired
	    private LogoutService logoutService;

	   @GetMapping("/logout")
	    public String logout(HttpSession session) {
		   logoutService.logout();
	        // Rediriger vers la page de connexion ou une page d'accueil
	       return "redirect:/login";
	    }


	}
