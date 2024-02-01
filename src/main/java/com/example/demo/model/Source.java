package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Timestamp;

@jakarta.persistence.Entity
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSource;
    private String nomSource;
    private String logo;
    private String linkSource;
    private int is_activated;
    private Long idUser;
    private Timestamp createdAt;
    public Long getIdSource() {
		return idSource;
	}
	public void setIdSource(Long idSource) {
		this.idSource = idSource;
	}
	public String getNomSource() {
		return nomSource;
	}
	public void setNomSource(String nomSource) {
		this.nomSource = nomSource;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getLinkSource() {
		return linkSource;
	}
	public void setLinkSource(String linkSource) {
		this.linkSource = linkSource;
	}
	public int getIsActivated() {
		return is_activated;
	}
	public void setIsActivated(int activate) {
		this.is_activated = activate;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	

}