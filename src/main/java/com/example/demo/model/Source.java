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
    private Long id_source;

    private String nom_source;
    private String logo;
    private String link_source;
    private int is_activated;
    @Override
	public String toString() {
		return "Source [id_source=" + id_source + ", nom_source=" + nom_source + ", logo=" + logo + ", link_source="
				+ link_source + ", is_activated=" + is_activated + ", created_at=" + created_at + ", user=" + user
				+ "]";
	}

	private Timestamp created_at;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


	public String getNom_source() {
		return nom_source;
	}

	public void setNom_source(String nom_source) {
		this.nom_source = nom_source;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLink_source() {
		return link_source;
	}

	public void setLink_source(String link_source) {
		this.link_source = link_source;
	}

	public int getIs_activated() {
		return is_activated;
	}

	public void setIs_activated(int is_activated) {
		this.is_activated = is_activated;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

    
}