package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.sql.Timestamp;



@Entity
@Table(name = "Domain")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Domain {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_domain")
	private Long idDomain;
	public String name_domain;
    private int is_activated;
    private Timestamp created_at;
    
    public Long getId_domain() {
		return idDomain;
	}
	public void setId_domain(Long id_domain) {
		this.idDomain = id_domain;
	}
	@Override
	public String toString() {
		return "Domain [id_domain=" + idDomain + ", name_domain=" + name_domain + ", is_activated=" + is_activated
				+ ", created_at=" + created_at + "]";
	}
	public String getName_domain() {
		return name_domain;
	}
	public void setName_domain(String name_domain) {
		this.name_domain = name_domain;
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