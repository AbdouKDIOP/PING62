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
import com.example.demo.model.Domain;
import com.example.demo.model.Produit;
import com.example.demo.model.Source;
import com.example.demo.model.Tool;
import com.example.demo.services.SignUpService;
import com.example.demo.services.WorkspaceService;
import com.example.demo.model.User;
import com.example.demo.model.Workspace;
import com.example.demo.repositoryDAO.DatasetRepository;
import com.example.demo.repositoryDAO.ProduitRepository;
import com.example.demo.repositoryDAO.WorkspaceRepository;
import com.example.demo.services.DatasetService;
import com.example.demo.services.DomainService;
import com.example.demo.services.LoginService;
import com.example.demo.services.LogoutService;
import com.example.demo.services.ProduitService;
import com.example.demo.services.SignUpService;
import com.example.demo.services.SourceService;
import com.example.demo.services.ToolService;
import com.example.demo.services.UserService;
import com.example.demo.services.WorkspaceService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "" })
public class Controlleur {
	@Autowired
	private SignUpService signUpService;
	private ProduitService produitService;
	private DatasetService datasetService;
	private DomainService domainService;
	private ToolService toolService; // Inject your service
	private SourceService sourceService;
	private UserService userService;
	private final WorkspaceService workspaceService;
	private DatasetRepository datasetRepository;
	private WorkspaceRepository workspaceRepository;

	@Autowired
	public Controlleur(SignUpService registrationService, ProduitService produitService, DatasetService datasetService,
			DomainService domainService, ToolService toolService, SourceService sourceService, UserService userService,
			WorkspaceService workspaceService) {
		this.signUpService = registrationService;
		this.produitService = produitService;
		this.datasetService = datasetService;
		this.domainService = domainService;
		this.toolService = toolService;
		this.sourceService = sourceService;
		this.userService = userService;
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

	@GetMapping({ "/actualite" })
	public String actualite(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		// Ajouter les informations sur l'utilisateur dans le modèle
		model.addAttribute("loggedInUser", loggedInUser);

		return "actualite";
	}

	@GetMapping({ "/add_incident" })
	public String add_incident(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		if (loggedInUser != null) {
			// Ajouter les informations sur l'utilisateur dans le modèle
			model.addAttribute("loggedInUser", loggedInUser);

			return "add_incidence";
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@GetMapping({ "/datasetAdmin" })
	public String datasetAdmin(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			// Ajouter les informations sur l'utilisateur dans le modèle
			model.addAttribute("loggedInUser", loggedInUser);
			List<Dataset> datasets = datasetService.findAll();
			model.addAttribute("datasets", datasets);
			List<Domain> domains = domainService.getAllDomains();
			model.addAttribute("domains", domains);
			List<Tool> tool = toolService.getAllTool();
			model.addAttribute("tool", tool);
			List<Source> source = sourceService.getAllSource();
			model.addAttribute("source", source);
			List<Workspace> workspace = workspaceService.getAllWorkspace();
			model.addAttribute("workspace", workspace);

			return "datasetAdmin";
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@GetMapping({ "/dataset" })
	public String dataset(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		model.addAttribute("loggedInUser", loggedInUser);
		List<Dataset> datasets = datasetService.findAll();
		model.addAttribute("datasets", datasets);
		return "dataset";
	}

	@GetMapping({ "/add_dataset" })
	public String add_dataset(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			List<Domain> domains = domainService.getAllDomains();
			model.addAttribute("domains", domains);
			List<Tool> tool = toolService.getAllTool();
			model.addAttribute("tool", tool);
			List<Source> source = sourceService.getAllSource();
			model.addAttribute("source", source);
			List<Workspace> workspace = workspaceService.getAllWorkspace();
			model.addAttribute("workspace", workspace);
			model.addAttribute("loggedInUser", loggedInUser);
			return "add_dataset";
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@PostMapping("/add_dataset")
	public String ajouterDataset(HttpSession session,
			@RequestParam("nameDataset") String nameDataset,
			Model model,
			@RequestParam("dataChampion") String dataChampion,
			@RequestParam("domainId") Long domainId,
			@RequestParam("toolId") Long toolId,
			@RequestParam("featureDetails") String featureDetails,
			@RequestParam("sourceId") Long sourceId,
			@RequestParam("workspaceId") Long workspaceId) {
		Dataset dataset = new Dataset();

		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		// Vérifier si l'utilisateur est connecté
		if (loggedInUser != null) {
			// Utiliser les informations de l'utilisateur
			Long userId = loggedInUser.getId_user();
			int userRole = loggedInUser.getIdRole();

			Domain domain = domainService.getDomainByIdDomain(domainId); // Assurez-vous d'avoir cette méthode dans
																			// votre service
			Tool tool = toolService.getToolById(toolId); // Assurez-vous d'avoir cette méthode dans votre service
			Source source = sourceService.getSourceById(sourceId); // Assurez-vous d'avoir cette méthode dans votre
																	// service
			User user = userService.getUserById(userId); // Assurez-vous d'avoir cette méthode dans votre service
			Workspace workspace = workspaceService.findWorkspaceById(workspaceId);

			dataset.setName_dataset(nameDataset);
			dataset.setData_champion(dataChampion);
			dataset.setDomain(domain);
			dataset.setTool(tool);
			dataset.setFeature_details(featureDetails);
			dataset.setSource(source);
			dataset.setUser(user);
			dataset.setWorkspace(workspace);

			// Sauvegarder le dataset dans la base de données
			datasetService.save(dataset); // Assurez-vous d'avoir cette méthode dans votre service

			if (userRole == 2) {
				// Si le rôle est 2(Membre de la ruche), redirigez vers produitAdmin
				return "redirect:/datasetRuche";
			} else if (userRole == 3) {
				// Si le rôle est 3(Admin), redirigez vers produitRuche
				return "redirect:/datasetAdmin";
			} else {
				// Gérer d'autres rôles si nécessaire
				return "redirect:/login"; // Remplacez par la page par défaut
			}
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@PostMapping("/update_dataset")
	public ResponseEntity<String> updateDataset(@RequestBody Map<String, String> updatedDataset, Model model) {
		// Utiliser la clé "id_dataset" pour obtenir l'ID du produit
		Long datasetId = Long.parseLong(updatedDataset.get("id_dataset"));

		Optional<Dataset> optionalDataset = datasetRepository.findById(datasetId);
		System.out.println("ID du dataset à mettre à jour : " + datasetId);

		if (optionalDataset.isPresent()) {
			Dataset dataset = optionalDataset.get();

			// Mise à jour des propriétés de l'entité Dataset
			dataset.setName_dataset(updatedDataset.get("name_dataset"));
			dataset.setData_champion(updatedDataset.get("data_champion"));

			// Mise à jour des références aux objets Domain, Source, Tool, et Workspace
			if (updatedDataset.get("id_domain") != null) {
				Domain updatedDomain = domainService
						.getDomainByIdDomain(Long.parseLong(updatedDataset.get("id_domain")));
				dataset.setDomain(updatedDomain);
			}

			if (updatedDataset.get("id_tool") != null) {
				Tool updatedTool = toolService.getToolById(Long.parseLong(updatedDataset.get("id_tool")));
				dataset.setTool(updatedTool);
			}

			dataset.setFeature_details(updatedDataset.get("feature_details"));

			if (updatedDataset.get("id_source") != null) {
				Source updatedSource = sourceService.getSourceById(Long.parseLong(updatedDataset.get("id_source")));
				dataset.setSource(updatedSource);
			}

			if (updatedDataset.get("id_workspace") != null) {
				Workspace updatedWorkspace = workspaceService
						.getWorkspaceById(Long.parseLong(updatedDataset.get("id_workspace")));
				dataset.setWorkspace(updatedWorkspace);
			}

			// Affichez les données avant la mise à jour
			System.out.println("Données du dataset avant mise à jour : " + dataset);

			// Enregistrez les modifications dans la base de données
			datasetRepository.save(dataset);

			// Affichez les données après la mise à jour
			System.out.println("Données du dataset après mise à jour : " + dataset);

			return ResponseEntity.ok("Données mises à jour avec succès");
		} else {
			// Affichez un message si le dataset n'est pas trouvé
			System.out.println("Dataset non trouvé avec l'ID : " + datasetId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dataset non trouvé");
		}
	}

	@DeleteMapping("/delete_dataset/{datasetId}")
	public ResponseEntity<String> deleteDataset(@PathVariable Long datasetId) {
		Optional<Dataset> optionalDataset = datasetRepository.findById(datasetId);

		if (optionalDataset.isPresent()) {
			Dataset dataset = optionalDataset.get();
			// Effectuez toute opération préalable à la suppression si nécessaire
			datasetRepository.delete(dataset);
			return ResponseEntity.ok("Produit supprimé avec succès");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé");
		}
	}

	@GetMapping({ "/datasetRuche" })
	public String datasetRuche(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		if (loggedInUser != null) {
			// Ajouter les informations sur l'utilisateur dans le modèle
			model.addAttribute("loggedInUser", loggedInUser);
			List<Dataset> datasets = datasetService.getDatasetByUser(loggedInUser);
			model.addAttribute("datasets", datasets);
			List<Domain> domains = domainService.getAllDomains();
			model.addAttribute("domains", domains);
			List<Tool> tool = toolService.getAllTool();
			model.addAttribute("tool", tool);
			List<Source> source = sourceService.getAllSource();
			model.addAttribute("source", source);
			List<Workspace> workspace = workspaceService.getAllWorkspace();
			model.addAttribute("workspace", workspace);

			return "datasetRuche";
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@GetMapping({ "/client" })
	public String client(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		// Ajouter les informations sur l'utilisateur dans le modèle
		model.addAttribute("loggedInUser", loggedInUser);

		return "client";
	}

	@GetMapping({ "/clientAdmin" })
	public String clientAdmin(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			// Ajouter les informations sur l'utilisateur dans le modèle
			model.addAttribute("loggedInUser", loggedInUser);

			return "clientAdmin";
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@GetMapping({ "/clientRuche" })
	public String clientRuche(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			// Ajouter les informations sur l'utilisateur dans le modèle
			model.addAttribute("loggedInUser", loggedInUser);

			return "clientRuche";
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@GetMapping({ "/contact2" })
	public String contact2(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		model.addAttribute("loggedInUser", loggedInUser);
		return "contact2";
	}

	@GetMapping({ "/contactezNous" })
	public String contactezNous(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		model.addAttribute("loggedInUser", loggedInUser);

		return "contactezNous";
	}

	@GetMapping({ "/domaine" })
	public String domaine(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		model.addAttribute("loggedInUser", loggedInUser);
		return "domaine";
	}

	@GetMapping({ "/headerAdmin" })
	public String headerAdmin() {
		return "headerConnect";
	}

	@GetMapping({ "/headerUserFSP" })
	public String headerUserFSP() {
		return "headerNonConnect";
	}

	@GetMapping({ "/headerUserRuche" })
	public String headerUserRuche() {
		return "headerRuche";
	}

	@GetMapping({ "/incidentAdmin" })
	public String incident(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		if (loggedInUser != null) {
			// Ajouter les informations sur l'utilisateur dans le modèle
			model.addAttribute("loggedInUser", loggedInUser);

			return "incidentAdmin";
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@GetMapping({ "/outil" })
	public String outil(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
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

	@GetMapping({ "/signup" })
	public String signup(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		// Ajouter les informations sur l'utilisateur dans le modèle
		model.addAttribute("loggedInUser", loggedInUser);

		return "signup";
	}

	// Mapping pour l'inscription de l'utilisateur
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
			@RequestParam("idDomaine") String domaine) {

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

	@GetMapping({ "/source" })
	public String source(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		model.addAttribute("loggedInUser", loggedInUser);
		return "source";
	}

	@GetMapping({ "/sourceAdmin" })
	public String sourceAdmin(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			// Ajouter les informations sur l'utilisateur dans le modèle
			model.addAttribute("loggedInUser", loggedInUser);

			return "sourceAdmin";
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@GetMapping({ "/sourceRuche" })
	public String sourceRuche(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			// Ajouter les informations sur l'utilisateur dans le modèle
			model.addAttribute("loggedInUser", loggedInUser);

			return "sourceRuche";
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@GetMapping({ "/headerc" })
	public String headerc() {
		return "headerConnect";
	}

	@GetMapping({ "/headerNc" })
	public String headerNc() {
		return "headerNonConnect";
	}

	@GetMapping({ "/mdpOublier" })
	public String mdpOublier(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		// Ajouter les informations sur l'utilisateur dans le modèle
		model.addAttribute("loggedInUser", loggedInUser);

		return "mdpOublier";
	}

	@GetMapping({ "/mdpChanger" })
	public String mdpChanger(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			// Ajouter les informations sur l'utilisateur dans le modèle
			model.addAttribute("loggedInUser", loggedInUser);

			return "mdpChanged";
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@GetMapping("/produitAdmin")
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

	@GetMapping({ "/produit" })
	public String produit(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		List<Produit> produits = produitService.getAllProduits();
		model.addAttribute("produits", produits);
		// Ajouter les informations sur l'utilisateur dans le modèle
		model.addAttribute("loggedInUser", loggedInUser);
		return "produit";
	}

	@GetMapping({ "/add_produit" })
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

	@GetMapping({ "/produitRuche" })
	public String produitRuche(Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			List<Produit> produits = produitService.getProduitsByIdUser(loggedInUser.getId_user());

			model.addAttribute("loggedInUser", loggedInUser);
			model.addAttribute("produits", produits);
			return "produitRuche";
		} else {
			// L'utilisateur n'est pas connecté, gérer cette situation en conséquence
			return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
		}
	}

	@PostMapping("/update_product")
	public String updateProduct(HttpSession session, @RequestBody Map<String, String> updatedProduct) {

		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			Long productId = Long.parseLong(updatedProduct.get("id")); // Utilisation de la clé "id" pour l'ID du
																		// produit

			Optional<Produit> optionalProduct = productRepository.findById(productId);
			System.out.println("Données reçues du frontend : " + updatedProduct);

			if (optionalProduct.isPresent()) {
				Produit product = optionalProduct.get();

				// Affichez les données actuelles du produit dans la console
				System.out.println("Données actuelles du produit : ");
				System.out.println("ID : " + product.getId()); // Utilisez le getter correspondant à l'ID
				System.out.println("Nom du produit : " + product.getNameProduct()); // Utilisez le getter correspondant
																					// au nom du produit

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

	@GetMapping({ "/incidentRuche" })
	public String incidentRuche(Model model, HttpSession session) {
		// Récupérer les informations de l'utilisateur depuis la session
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		// Ajouter les informations sur l'utilisateur dans le modèle
		model.addAttribute("loggedInUser", loggedInUser);

		return "incidentRuche";
	}

	@GetMapping({ "/footer" })
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
