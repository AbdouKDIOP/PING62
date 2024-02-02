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
    private Long id_workspace;
    @Column(name = "name_workspace")
    private String name_workspace;
	public String getName_workspace() {
		return name_workspace;
	}
	public void setName_workspace(String name_workspace) {
		this.name_workspace = name_workspace;
	}
	@Override
	public String toString() {
		return "Workspace [id_workspace=" + id_workspace + ", name_workspace=" + name_workspace + "]";
	}
	public Long getId_workspace() {
		return id_workspace;
	}
	public void setId_workspace(Long id_workspace) {
		this.id_workspace = id_workspace;
	}
}
