package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "email", nullable = false, length = 70)
    private String email;

    @Column(name = "password", nullable = false, length = 70)
    private String password;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "prenom", length = 100)
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "id_poste")
    private Poste poste;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    @Column(name = "status_user", nullable = false)
    private int statusUser;

    @ManyToOne
    @JoinColumn(name = "id_domaine", nullable = false)
    private Domaine domaine;
    
    
    
    public Long getIdUser() {
		return idUser;
	}



	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Poste getPoste() {
		return poste;
	}



	public void setPoste(Poste poste) {
		this.poste = poste;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public int getStatusUser() {
		return statusUser;
	}



	public void setStatusUser(int statusUser) {
		this.statusUser = statusUser;
	}



	public Domaine getDomaine() {
		return domaine;
	}



	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}



	@Override
    public String toString() {
        return "User [idUser=" + idUser + ", email=" + email + ", password=" + password +
                ", nom=" + nom + ", prenom=" + prenom + ", poste=" + poste +
                ", role=" + role + ", statusUser=" + statusUser + ", domaine=" + domaine + "]";
    }
}
