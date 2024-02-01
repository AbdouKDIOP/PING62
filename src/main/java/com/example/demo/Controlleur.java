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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.example.demo.model.Client;
import com.example.demo.model.Dataset;
import com.example.demo.model.Poste;
import com.example.demo.model.Source;
import com.example.demo.model.Produit;
import com.example.demo.services.SignUpService;
import com.example.demo.model.User;
import com.example.demo.repositoryDAO.ProduitRepository;
import com.example.demo.repositoryDAO.SourceRepository;
import com.example.demo.services.ClientService;
import com.example.demo.services.PosteService;
import com.example.demo.services.SourceService;
import com.example.demo.services.UserService;
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
	    private UserService userService;
	    @Autowired
	    public Controlleur(SignUpService registrationService, ProduitService produitService, DatasetService datasetService, SourceService sourceService, UserService userService) {
	        this.signUpService = registrationService;
	        this.produitService = produitService;
	        this.datasetService = datasetService;
	        this.sourceService = sourceService;
	        this.userService = userService;
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
 
	    @Autowired
	    private ClientService clientService;
		   @GetMapping({"/client"})
		   public String client(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);
			    List<Client> clients = clientService.findAll();
		        model.addAttribute("clients", clients);
 
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
 
		   @GetMapping("/contact2")
		   public String contact2(@RequestParam(name = "roleId", required = false) Long roleId, Model model, HttpSession session) {
		       // Récupérer les informations de l'utilisateur depuis la session
		       User loggedInUser = (User) session.getAttribute("loggedInUser");
 
		       // Ajouter les informations sur l'utilisateur dans le modèle
		       model.addAttribute("loggedInUser", loggedInUser);
 
		       // Vérifier si le paramètre "roleId" est présent
		       if (roleId != null) {
		    	   List<User> usersWithRoleId = userService.findUsersByRoleId(roleId);
 
		           // Faire quelque chose avec roleId
		           model.addAttribute("roleId", roleId);
 
		           // Ajouter la liste d'utilisateurs au modèle
		           model.addAttribute("usersWithRoleId", usersWithRoleId);
		           }
 
		       return "contact2";
		   }
 
		    @Autowired
		    private PosteService posteService;
		   @GetMapping({"/contactezNous"})
		   public String contactezNous(Model model, HttpSession session) {
			    // Récupérer les informations de l'utilisateur depuis la session
			    User loggedInUser = (User) session.getAttribute("loggedInUser");
			    // Ajouter les informations sur l'utilisateur dans le modèle
			    model.addAttribute("loggedInUser", loggedInUser);
			    List<Poste> postes = posteService.findAll();
		        model.addAttribute("postes", postes);
 
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
			      //  user.setPoste(poste);
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
	   @Autowired
	    private final SourceService sourceService;
	   @GetMapping({"/source"})
	   public String source(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);
		    List<Source> sources = sourceService.getAllSources();
	        model.addAttribute("sources", sources);
 
	      return "source";
	   }
	   @Autowired
	    private SourceRepository sourceRepository;
	   @PostMapping("/modifySource")
	   public ResponseEntity<?> modifySource(@RequestParam Long sourceId, @RequestParam String newName) {
	       Optional<Source> sourceOptional = sourceRepository.findById(sourceId);
	       if (sourceOptional.isPresent()) {
	           Source source = sourceOptional.get();
	           source.setNomSource(newName);
	           System.out.printf("active",newName);
	           sourceRepository.save(source);
	           return ResponseEntity.ok().build();
	       } else {
	           return ResponseEntity.notFound().build();
	       }
	   }

	   @PostMapping("/toggleSourceActivation")
	   public ResponseEntity<?> toggleSourceActivation(@RequestParam Long sourceId, @RequestParam int activate) {
   Optional<Source> sourceOptional = sourceRepository.findById(sourceId);
	       if (sourceOptional.isPresent()) {
	           Source source = sourceOptional.get();
	           source.setIsActivated(activate); // Ici, setIsActivated doit accepter un int
	           System.out.printf("active",source);
	           System.out.printf("id",activate);
	           sourceRepository.save(source);
	           return ResponseEntity.ok().build();
	       } else {
	           return ResponseEntity.notFound().build();
	       }
	   }


 
 
	   @GetMapping({"/sourceAdmin"})
	   public String sourceAdmin(Model model, HttpSession session) {
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);
		    List<Source> sources = sourceService.getAllSources();
	        model.addAttribute("sources", sources);
 
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
		    // Récupérer les informations de l'utilisateur depuis la session
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    // Ajouter les informations sur l'utilisateur dans le modèle
		    model.addAttribute("loggedInUser", loggedInUser);
 
	      return "add_produit";
	   }
	  /* @PostMapping("/ajouter-source")
	    public String ajouterSource(@ModelAttribute("sourceForm") Source source) {
	        sourceService.ajouterSource(source);
	        return "redirect:/page-de-confirmation"; // Rediriger vers une page de confirmation
	    }
	   */
	   @PostMapping("/add_source")
	   public String addSource(HttpSession session,
			   					@RequestParam("logo") String logo,
	                            @RequestParam("name") String nomSource) throws java.text.ParseException {
	       // Créer une nouvelle instance d'Incident
	       Source source = new Source();
	    // Récupérer les informations de l'utilisateur depuis la session
	        User loggedInUser = (User) session.getAttribute("loggedInUser");
	     // Vérifier si l'utilisateur est connecté
	      /*  if (loggedInUser != null) {
	            // Utiliser les informations de l'utilisateur
	            Long userId = loggedInUser.getId_user();
 
	            source.setNomSource(nomSource);
	            source.setIdSource(datasetId);
	            product.setDataChampion(dataChampion);
	            product.setIdWorkspace(workspaceId);
	            product.setSummary(summary);
	            product.setLink(link);
	            product.setPerimeter(perimeter);
	            product.setFeatureDetails(featureDetails);
	            LocalDateTime localDateTime = LocalDateTime.now();
	            Timestamp timestamp = Timestamp.valueOf(localDateTime);
	            product.setCreatedAt(timestamp);
	            product.setIdUser(userId);
	       // Enregistrement de l'incident dans la base de données
	       sourceRepository.save(source);
			*/
	       // Rediriger vers la page d'administration des incidents
	       return "redirect:/sourceAdmin";
	   }
	   @Autowired
	    private ProduitRepository productRepository;
 
	    @PostMapping("/add_produit")
	    public String ajouterProduit(HttpSession session,
	    		@RequestParam("nameProduct") String nameProduct,
			    @RequestParam("idDataset") String idDataset,
			    Model model,
			    @RequestParam("dataChampion") String dataChampion,
			    @RequestParam("idWorkspace") String idWorkspace,
			    @RequestParam("summary") String summary,
			    @RequestParam("link") String link,
			    @RequestParam("perimeter") String perimeter,
			    @RequestParam("featureDetails") String featureDetails) {
	        Produit product = new Produit();
 
 
	     // Convertir les valeurs String en int
	        Long datasetId = Long.parseLong(idDataset);
	        Long workspaceId = Long.parseLong(idWorkspace);

	     // Récupérer les informations de l'utilisateur depuis la session
	        User loggedInUser = (User) session.getAttribute("loggedInUser");
 
	     // Vérifier si l'utilisateur est connecté
	        if (loggedInUser != null) {
	            // Utiliser les informations de l'utilisateur
	            Long userId = loggedInUser.getId_user();
 
	            product.setNameProduct(nameProduct);
	            product.setIdDataset(datasetId);
	            product.setDataChampion(dataChampion);
	            product.setIdWorkspace(workspaceId);
	            product.setSummary(summary);
	            product.setLink(link);
	            product.setPerimeter(perimeter);
	            product.setFeatureDetails(featureDetails);
	            LocalDateTime localDateTime = LocalDateTime.now();
	            Timestamp timestamp = Timestamp.valueOf(localDateTime);
	            product.setCreatedAt(timestamp);
	            product.setIdUser(userId);
	            productRepository.save(product);
 
	            // Redirigez vers la page des produits ou une autre page après l'insertion
	            return "redirect:/produitAdmin";
	        } else {
	            // L'utilisateur n'est pas connecté, gérer cette situation en conséquence
	            return "redirect:/login"; // Ou une autre page d'erreur ou de connexion
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
		    public ResponseEntity<String> updateProduct(@RequestBody Map<String, String> updatedProduct) {
		        Long productId = Long.parseLong(updatedProduct.get("0")); // L'indice 0 représente l'ID du produit
 
		        Optional<Produit> optionalProduct = productRepository.findById(productId);
		        System.out.println("Données reçues du frontend : " + updatedProduct);
 
		        if (optionalProduct.isPresent()) {
		            Produit product = optionalProduct.get();
		            // Mettez à jour les propriétés du produit avec les nouvelles valeurs de la carte updatedProduct
		            product.setNameProduct(updatedProduct.get("1"));
		            product.setIdDataset(Long.parseLong(updatedProduct.get("2")));
		            product.setDataChampion(updatedProduct.get("3"));
		            product.setIdWorkspace(Long.parseLong(updatedProduct.get("4")));
		            product.setSummary(updatedProduct.get("5"));
		            product.setLink(updatedProduct.get("6"));
		            System.out.println("Données reçues du frontend : " + updatedProduct);
		            product.setPerimeter(updatedProduct.get("7"));
		            System.out.println("Données reçues du frontend : " + updatedProduct);
		            product.setFeatureDetails(updatedProduct.get("8"));
		            System.out.println("Données reçues du frontend : " + updatedProduct);
 
		            productRepository.save(product);
 
		            return ResponseEntity.ok("Données mises à jour avec succès");
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