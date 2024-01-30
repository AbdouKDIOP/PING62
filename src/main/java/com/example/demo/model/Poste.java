package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Poste")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Poste {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_poste;
	private String name_poste;
    private String description;
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
