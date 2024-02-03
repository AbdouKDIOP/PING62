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
    private int idPoste;

    @Column(name = "id_role")
    private int idRole;

    @Column(name = "password")
    private String password;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "id_domaine")
    private int idDomaine;

    @Column(name = "status_user")
    private int statusUser = 0;
    // Constructeurs, getters, setters...



    public String getEmail() {
        return email;
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
		this.idPoste = idPoste;
		this.idRole = idRole;
		this.password = password;
		this.prenom = prenom;
		this.statusUser = statusUser;
	}

	public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdUser() {
		return idUser;
	}



	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}



	public int getIdPoste() {
		return idPoste;
	}



	public void setIdPoste(int idPoste) {
		this.idPoste = idPoste;
	}



	public int getIdRole() {
		return idRole;
	}



	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}



	public int getIdDomaine() {
		return idDomaine;
	}



	public void setIdDomaine(int idDomaine) {
		this.idDomaine = idDomaine;
	}



	public int getStatusUser() {
		return statusUser;
	}



	public void setStatusUser(int statusUser) {
		this.statusUser = statusUser;
	}



	public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }




    
}
