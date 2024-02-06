package com.example.demo.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "incident")
public class Incident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_incident")
	private Long id_incident;

	@Column(name = "date_incident")
	private Date date_incident;

	@Column(name = "title_incident")
	private String title_incident;

	@Column(name = "description_incident")
	private String description_incident;

	@Column(name = "is_activated")
	private boolean is_activated;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "id_user")
	private Long id_user;

	/*@Column(name = "id_typeincident")
    private Long id_typeincident;*/



	@ManyToOne
	@JoinColumn(name = "id_typeincident")
	private TypeIncident typeincident;

	public Incident() {
	}

	public TypeIncident getTypeincident() {
		return typeincident;
	}

	public void setTypeincident(TypeIncident typeincident) {
		this.typeincident = typeincident;
	}

	public Long getId_incident() {
		return id_incident;
	}

	public void setId_incident(Long id_incident) {
		this.id_incident = id_incident;
	}

	public Date getDate_incident() {
		return date_incident;
	}

	public void setDate_incident(Date date_incident) {
		this.date_incident = date_incident;
	}

	public String getTitle_incident() {
		return title_incident;
	}

	public void setTitle_incident(String title_incident) {
		this.title_incident = title_incident;
	}

	public String getDescription_incident() {
		return description_incident;
	}

	public void setDescription_incident(String description_incident) {
		this.description_incident = description_incident;
	}

	public boolean getIs_activated() {
		return is_activated;
	}

	public void setIs_activated(boolean is_activated) {
		this.is_activated = is_activated;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	@Override
	public String toString() {
		return "Incident [id_incident=" + id_incident + ", date_incident=" + date_incident + ", title_incident="
				+ title_incident + ", description_incident=" + description_incident + ", is_activated=" + is_activated
				+ ", createdAt=" + createdAt + ", id_user=" + id_user + ", typeincident=" + typeincident + "]";
	}


}