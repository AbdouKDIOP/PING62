package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Workspace")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workspace {
    public Long getIdWorkspace() {
		return idWorkspace;
	}
	public void setIdWorkspace(Long idWorkspace) {
		this.idWorkspace = idWorkspace;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWorkspace;
    private String name_workspace;
	public String getName_workspace() {
		return name_workspace;
	}
	public void setName_workspace(String name_workspace) {
		this.name_workspace = name_workspace;
	}
	@Override
	public String toString() {
		return "Workspace [id_workspace=" + idWorkspace + ", name_workspace=" + name_workspace + "]";
	}
}