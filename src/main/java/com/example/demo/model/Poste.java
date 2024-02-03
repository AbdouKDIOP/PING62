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
	private Long idPoste;
	private String namePoste;
    private String description;

	public Long getIdPoste() {
		return idPoste;
	}
	public void setIdPoste(Long idPoste) {
		this.idPoste = idPoste;
	}
	public String getNamePoste() {
		return namePoste;
	}
	public void setNamePoste(String namePoste) {
		this.namePoste = namePoste;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
