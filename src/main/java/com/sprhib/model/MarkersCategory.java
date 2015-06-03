package com.sprhib.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class MarkersCategory {

	@Id
	@GeneratedValue
	private int idCategory;
	private String name;
	private String description;
	private String iconUrl;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	private List<Marker> markers;
	//private int publicMap;
	
	public List<Marker> getMarkers() {
		return markers;
	}

	public void setMarkers(List<Marker> markers) {
		this.markers = markers;
	}

	public MarkersCategory() {
	}
	
	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
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