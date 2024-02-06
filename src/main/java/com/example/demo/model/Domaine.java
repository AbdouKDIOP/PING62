package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Domain")
@AllArgsConstructor
@NoArgsConstructor
public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domain")
    private Long idDomain;

    @Column(name = "name_domain", nullable = false)
    private String nameDomain;

    @Column(name = "is_activated", nullable = false)
    private boolean isActivated;

    @Column(name = "created_at", nullable = false)
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




	public boolean isActivated() {
		return isActivated;
	}




	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}




	public Timestamp getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
    public String toString() {
        return "Domain [idDomain=" + idDomain + ", nameDomain=" + nameDomain + ", isActivated=" + isActivated
                + ", createdAt=" + createdAt + "]";
    }
}
