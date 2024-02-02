package com.example.demo.model;
import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private Long id;

    @Column(name = "idUser", nullable = true)
    private Long idUser;

    @Column(name = "nameProduct", nullable = true, unique = true)
    private String nameProduct;

    @Column(name = "dataChampion", nullable = true)
    private String dataChampion;

	@ManyToOne
    @JoinColumn(name = "id_dataset")
    private Dataset dataset;

	@ManyToOne
    @JoinColumn(name = "id_workspace")
    private Workspace workspace;

    @Column(name = "createdAt", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = Timestamp.from(Instant.now());
    }

    @Column(name = "summary", nullable = true, columnDefinition = "LONGTEXT")
    private String summary;

    @Column(name = "link", nullable = true)
    private String link;

    @Column(name = "perimeter", nullable = true, columnDefinition = "LONGTEXT")
    private String perimeter;

    
    @Column(name = "featureDetails", nullable = true, columnDefinition = "LONGTEXT")
    private String featureDetails;

    // Les getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDataChampion() {
        return dataChampion;
    }

    public void setDataChampion(String dataChampion) {
        this.dataChampion = dataChampion;
    }


    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp timestamp) {
        this.createdAt = timestamp;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(String perimeter) {
        this.perimeter = perimeter;
    }

    public String getFeatureDetails() {
        return featureDetails;
    }

    public void setFeatureDetails(String featureDetails) {
        this.featureDetails = featureDetails;
    }
	public Dataset getDataset() {
		return dataset;
	}

	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

}