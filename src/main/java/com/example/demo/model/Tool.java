package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Tool")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tool {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTool;

    private String nameTool;
    private String logoTool;
    private int isActivated;
    private Timestamp createdAt;
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
	public int getIsActivated() {
		return isActivated;
	}
	public void setIsActivated(int isActivated) {
		this.isActivated = isActivated;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}



    
}
