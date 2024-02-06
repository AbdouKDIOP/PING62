package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Poste")
@AllArgsConstructor
@NoArgsConstructor
public class Poste {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poste")
    private Long idPoste;

    @Column(name = "name_poste", length = 200, nullable = false)
    private String namePoste;

    @Column(name = "description", columnDefinition = "longtext")
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