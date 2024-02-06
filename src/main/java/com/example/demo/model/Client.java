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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;

	@Column(name = "name_client", nullable = false)
    private String nameClient;

    @Column(name = "description_client", nullable = false, columnDefinition = "LONGTEXT")
    private String descriptionClient;

    @Column(name = "logo_client")
    private String logoClient;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "is_activated", nullable = false)
    private Boolean isActivated;

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getDescriptionClient() {
		return descriptionClient;
	}

	public void setDescriptionClient(String descriptionClient) {
		this.descriptionClient = descriptionClient;
	}

	public String getLogoClient() {
		return logoClient;
	}

	public void setLogoClient(String logoClient) {
		this.logoClient = logoClient;
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

	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}
}