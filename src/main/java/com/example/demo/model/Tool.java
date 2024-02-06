package com.example.demo.model;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tool")
@AllArgsConstructor
@NoArgsConstructor
public class Tool {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tool")
    private Long idTool;

    @Column(name = "name_tool", unique = true, nullable = false)
    private String nameTool;

    @Column(name = "logo_tool")
    private String logoTool;

    @Column(name = "is_activated", nullable = false)
    private boolean isActivated;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

	@Override
	public String toString() {
		return "Tool [id_tool=" + idTool + ", name_tool=" + nameTool + ", logo_tool=" + logoTool + ", is_activated="
				+ isActivated + ", created_at=" + createdAt + "]";
	}

	public Long getIdTool() {
		return idTool;
	}

	public void setIdTool(Long idTool) {
		this.idTool = idTool;
	}

	public String getNameTool() {
		return nameTool;
	}

	public void setNameTool(String nameTool) {
		this.nameTool = nameTool;
	}

	public String getLogoTool() {
		return logoTool;
	}

	public void setLogoTool(String logoTool) {
		this.logoTool = logoTool;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

}