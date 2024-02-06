package com.example.demo.model;


import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Source")
@AllArgsConstructor
@NoArgsConstructor
public class Source {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_source")
    private Long idSource;

    @Column(name = "nom_source", nullable = false)
    private String nomSource;

    @Column(name = "logo")
    private String logo;

    @Column(name = "link_source")
    private String linkSource;

    @Column(name = "is_activated", nullable = false)
    private int isActivated;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "created_at", nullable = false)
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
		return isActivated;
	}




	public void setIsActivated(int isActivated) {
		this.isActivated = isActivated;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Timestamp getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}




	@Override
    public String toString() {
        return "Source [idSource=" + idSource + ", nomSource=" + nomSource + ", logo=" + logo +
                ", linkSource=" + linkSource + ", isActivated=" + isActivated +
                ", user=" + user + ", createdAt=" + createdAt + "]";
    }
}