package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "Client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;

    private String name_client;
    private String description_dlient;
    private String logo_client;
    private int is_activated;
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

	public String getName_client() {
		return name_client;
	}

	public void setName_client(String name_client) {
		this.name_client = name_client;
	}

	public String getDescription_dlient() {
		return description_dlient;
	}

	public void setDescription_dlient(String description_dlient) {
		this.description_dlient = description_dlient;
	}

	public String getLogo_client() {
		return logo_client;
	}

	public void setLogo_client(String logo_client) {
		this.logo_client = logo_client;
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