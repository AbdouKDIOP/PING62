package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	private String nameRole;
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

}
