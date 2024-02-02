package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "domaine")
public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domaine")
    private int idDomaine;

    @Column(name = "nom_domaine", nullable = false, length = 100)
    private String nomDomaine;

    // Constructors, getters, setters...

    public Domaine() {
        // Default constructor
    }

    public Domaine(int idDomaine, String nomDomaine) {
        this.idDomaine = idDomaine;
        this.nomDomaine = nomDomaine;
    }

	public int getIdDomaine() {
		return idDomaine;
	}

	public void setIdDomaine(int idDomaine) {
		this.idDomaine = idDomaine;
	}

	public String getNomDomaine() {
		return nomDomaine;
	}

	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}

   

}

