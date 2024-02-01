package com.example.demo.model;
import jakarta.persistence.Entity;

@Entity
public class Client {
    @jakarta.persistence.Id
    private int id_client;
    private String name_client;
    private String description_client;
    private String logo_client;
    
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getName_client() {
		return name_client;
	}
	public void setName_client(String name_client) {
		this.name_client = name_client;
	}
	public String getDescription_client() {
		return description_client;
	}
	public void setDescription_client(String description_client) {
		this.description_client = description_client;
	}
	public String getLogo_client() {
		return logo_client;
	}
	public void setLogo_client(String logo_client) {
		this.logo_client = logo_client;
	}
   
}