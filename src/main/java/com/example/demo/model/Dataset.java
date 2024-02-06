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
@Table(name = "Dataset")
@AllArgsConstructor
@NoArgsConstructor
public class Dataset {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dataset")
    private Long idDataset;

    @ManyToOne
    @JoinColumn(name = "id_domain", nullable = false)
    private Domaine domain;

    @ManyToOne
    @JoinColumn(name = "id_source", nullable = false)
    private Source source;

    @ManyToOne
    @JoinColumn(name = "id_tool", nullable = false)
    private Tool tool;

    @ManyToOne
    @JoinColumn(name = "id_workspace", nullable = false)
    private Workspace workspace;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "name_dataset", nullable = false, unique = true, length = 250)
    private String nameDataset;

    @Column(name = "data_champion", nullable = false, length = 200)
    private String dataChampion;

    @Column(name = "feature_details", nullable = false, columnDefinition = "LONGTEXT")
    private String featureDetails;
    
    
    
    public Long getIdDataset() {
		return idDataset;
	}



	public void setIdDataset(Long idDataset) {
		this.idDataset = idDataset;
	}



	public Domaine getDomain() {
		return domain;
	}



	public void setDomain(Domaine domain) {
		this.domain = domain;
	}



	public Source getSource() {
		return source;
	}



	public void setSource(Source source) {
		this.source = source;
	}



	public Tool getTool() {
		return tool;
	}



	public void setTool(Tool tool) {
		this.tool = tool;
	}



	public Workspace getWorkspace() {
		return workspace;
	}



	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
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



	public String getNameDataset() {
		return nameDataset;
	}



	public void setNameDataset(String nameDataset) {
		this.nameDataset = nameDataset;
	}



	public String getDataChampion() {
		return dataChampion;
	}



	public void setDataChampion(String dataChampion) {
		this.dataChampion = dataChampion;
	}



	public String getFeatureDetails() {
		return featureDetails;
	}



	public void setFeatureDetails(String featureDetails) {
		this.featureDetails = featureDetails;
	}



	@Override
    public String toString() {
        return "Dataset [idDataset=" + idDataset + ", domain=" + domain +
                ", source=" + source + ", tool=" + tool + ", workspace=" + workspace +
                ", user=" + user + ", createdAt=" + createdAt + ", nameDataset=" + nameDataset +
                ", dataChampion=" + dataChampion + ", featureDetails=" + featureDetails + "]";
    }
}