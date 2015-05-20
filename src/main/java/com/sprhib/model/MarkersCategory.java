package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class MarkersCategory {

	@Id
	@GeneratedValue
	private int idCategory;
	private String name;
	private String description;
	//private int publicMap;
	
	protected MarkersCategory() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public int isPublicMap() {
//		return publicMap;
//	}
//	public void setPublicMap(int publicMap) {
//		this.publicMap = publicMap;
//	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	

}