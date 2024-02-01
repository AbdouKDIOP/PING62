package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Poste {
    @Id
    private int id_poste;
    private String name_poste;
    private String description;
    public int getId_poste() {
		return id_poste;
	}
	public void setId_poste(int id_poste) {
		this.id_poste = id_poste;
	}
	public String getName_poste() {
		return name_poste;
	}
	public void setName_poste(String name_poste) {
		this.name_poste = name_poste;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}