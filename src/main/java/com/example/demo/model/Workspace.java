package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Workspace")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_workspace")
    private Long idWorkspace;
    @Column(name = "name_workspace")
    private String nameWorkspace;
	public Long getIdWorkspace() {
		return idWorkspace;
	}
	public void setIdWorkspace(Long idWorkspace) {
		this.idWorkspace = idWorkspace;
	}
	public String getNameWorkspace() {
		return nameWorkspace;
	}
	public void setNameWorkspace(String nameWorkspace) {
		this.nameWorkspace = nameWorkspace;
	}

}
