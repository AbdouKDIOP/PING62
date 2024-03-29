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
	private Long id_role;
	private String name_role;
	public String getName_role() {
		return name_role;
	}
	public void setName_role(String name_role) {
		this.name_role = name_role;
	}
}
