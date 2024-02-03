package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "Source")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSource;

    private String nomSource;
    private String logo;
    private String linkSource;
    private int isActivated;
 

	private Timestamp created_at;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

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

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


    
}