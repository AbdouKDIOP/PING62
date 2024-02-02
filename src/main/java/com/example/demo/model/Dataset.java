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
    
    @Override
	public String toString() {
		return "Dataset [id_dataset=" + idDataset + ", domain=" + domain + ", source=" + source + ", tool=" + tool
				+ ", workspace=" + workspace + ", user=" + user + ", created_at=" + created_at + ", name_dataset="
				+ name_dataset + ", data_champion=" + data_champion + ", feature_details=" + feature_details + "]";
	}
	@ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    private Timestamp created_at;
    private String name_dataset;
    private String data_champion;
    private String feature_details;
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public String getName_dataset() {
		return name_dataset;
	}
	public void setName_dataset(String name_dataset) {
		this.name_dataset = name_dataset;
	}
	public String getData_champion() {
		return data_champion;
	}
	public void setData_champion(String data_champion) {
		this.data_champion = data_champion;
	}
	public String getFeature_details() {
		return feature_details;
	}
	public void setFeature_details(String feature_details) {
		this.feature_details = feature_details;
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