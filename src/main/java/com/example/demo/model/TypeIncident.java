package com.example.demo.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_incident")
public class TypeIncident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_typeincident")
    private Long id_typeincident;

	@Column(name = "type_incident")
    private String type_incident;


	public Long getId_typeincident() {
		return id_typeincident;
	}

	public void setId_typeincident(Long id_typeincident) {
		this.id_typeincident = id_typeincident;
	}

	public String getType_incident() {
		return type_incident;
	}

	public void setType_incident(String type_incident) {
		this.type_incident = type_incident;
	}

	public TypeIncident() {
	}
	
	
}

