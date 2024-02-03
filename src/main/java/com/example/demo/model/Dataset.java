package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "Dataset")
@AllArgsConstructor
@NoArgsConstructor
public class Dataset {
    public Long getId_dataset() {
		return idDataset;
	}
	public void setId_dataset(Long id_dataset) {
		this.idDataset = id_dataset;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dataset")
    private Long idDataset;

    @ManyToOne
    @JoinColumn(name = "id_domain")
    private Domain domain;

    @ManyToOne
    @JoinColumn(name = "id_source")
    private Source source;

    @ManyToOne
    @JoinColumn(name = "id_Tool")
    private Tool tool;

  
	@ManyToOne
    @JoinColumn(name = "id_workspace")
    private Workspace workspace;

	@ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    private Timestamp createdAt;
    private String nameDataset;
    private String dataChampion;
    private String featureDetails;

	
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
	public Domain getDomain() {
			return domain;
		}
		public void setDomain(Domain domain) {
			this.domain = domain;
		}
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
		
		
		public Source getSource() {
			return source;
		}
		public Long getIdDataset() {
			return idDataset;
		}
		public void setIdDataset(Long idDataset) {
			this.idDataset = idDataset;
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
}