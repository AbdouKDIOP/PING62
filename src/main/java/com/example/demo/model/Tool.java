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
    @Override
	public String toString() {
		return "Tool [id_tool=" + id_tool + ", name_tool=" + name_tool + ", logo_tool=" + logo_tool + ", is_activated="
				+ is_activated + ", created_at=" + created_at + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tool;

    private String name_tool;
    private String logo_tool;
    private int is_activated;
    private Timestamp created_at;

	public String getName_tool() {
		return name_tool;
	}

	public void setName_tool(String name_tool) {
		this.name_tool = name_tool;
	}

	public String getLogo_tool() {
		return logo_tool;
	}

	public void setLogo_tool(String logo_tool) {
		this.logo_tool = logo_tool;
	}

	public int getIs_activated() {
		return is_activated;
	}

	public void setIs_activated(int is_activated) {
		this.is_activated = is_activated;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

    
}
