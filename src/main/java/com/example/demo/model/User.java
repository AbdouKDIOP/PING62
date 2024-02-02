package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "email")
    private String email;

    @Column(name = "nom")
    private String nom;
    
	@Column(name = "id_poste")
    private int id_poste;

    @Column(name = "id_role")
    private int id_role;

    @Column(name = "password")
    private String password;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "id_domaine")
    private int id_domaine;

    @Column(name = "status_user")
    private int status_user = 0;
    // Constructeurs, getters, setters...



    public String getEmail() {
        return email;
    }

    public Long getId_user() {
		return idUser;
	}

	public void setId_user(Long id_user) {
		this.idUser = id_user;
	}

	public int getId_poste() {
		return id_poste;
	}

	public void setId_poste(int id_poste) {
		this.id_poste = id_poste;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public int getStatus_user() {
		return status_user;
	}

	public void setStatus_user(int status_user) {
		this.status_user = status_user;
	}

	public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }
    
    public User() {
        // constructeur par défaut
    }
    
	public User(Long idUser, String email, String nom, int idPoste, int idRole, String password, String prenom,
			int service, int statusUser) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.nom = nom;
		this.id_poste = idPoste;
		this.id_role = idRole;
		this.password = password;
		this.prenom = prenom;
		this.id_domaine = service;
		this.status_user = statusUser;
	}

	public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    public int getId_domaine() {
		return id_domaine;
	}

	public void setId_domaine(int id_domaine) {
		this.id_domaine = id_domaine;
	}

	public int getStatusUser() {
        return status_user;
    }

    public void setStatusUser(int statusUser) {
        this.status_user = statusUser;
    }

	public int getIdPoste() {
		return id_poste;
	}

	public void setIdPoste(int idPoste) {
		this.id_poste = idPoste;
	}

	public int getIdRole() {
		return id_role;
	}

	public void setIdRole(int idRole) {
		this.id_role = idRole;
	}

    
}
