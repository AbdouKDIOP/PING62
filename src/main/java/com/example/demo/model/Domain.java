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
    private Long idDomain;

	public String nameDomain;
    private int isActivated;
    private Timestamp createdAt;
	public Long getIdDomain() {
		return idDomain;
	}
	public void setIdDomain(Long idDomain) {
		this.idDomain = idDomain;
	}
	public String getNameDomain() {
		return nameDomain;
	}
	public void setNameDomain(String nameDomain) {
		this.nameDomain = nameDomain;
	}

	public int getIsActivated() {
		return isActivated;
	}
	public void setIsActivated(int isActivated) {
		this.isActivated = isActivated;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

}