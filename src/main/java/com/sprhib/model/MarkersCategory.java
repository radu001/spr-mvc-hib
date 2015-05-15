package com.sprhib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class MarkersCategory {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private List<Marker> markers;
	private boolean publicMap;

	public MarkersCategory(int id, String title, String description,
			boolean publicMap) {
		setName(title);
		setId(id);
		this.description = description;
		this.publicMap = publicMap;

		markers = new ArrayList<Marker>();
	}

	public boolean addMarker(Marker marker) {
		return markers.add(marker);
	}

	public boolean removeMarker(Marker marker) {
		return markers.remove(marker);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Marker> getMarkers() {
		return markers;
	}

	public boolean isPublicMap() {
		return publicMap;
	}

	public void setPublicMap(boolean publicMap) {
		this.publicMap = publicMap;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
