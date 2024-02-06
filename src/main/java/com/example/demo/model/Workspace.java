package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Workspace")
@AllArgsConstructor
@NoArgsConstructor
public class Workspace {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_workspace")
    private Long idWorkspace;

    @Column(name = "name_workspace", nullable = false)
    private String nameWorkspace;

    public Workspace() {
    }

    public Workspace(String nameWorkspace) {
        this.nameWorkspace = nameWorkspace;
    }
	
    
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

	@Override
	public String toString() {
		return "Workspace [id_workspace=" + idWorkspace + ", name_workspace=" + nameWorkspace + "]";
	}
}