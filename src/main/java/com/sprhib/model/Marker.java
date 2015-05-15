package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marker")
public class Marker implements Comparable<Marker> {


	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private String iconUrl;
	private double latitude;
	private double longitude;
	private String site;
	private int fk_category;
	private String routeStr;
	private String imageUrl;
	private String address;




	public Marker(int idMarker, String title, String description, String address, String imageUrl,
			String iconUrl, String site, double latitude, double longitude, String routeStr, int fk_category) {
		setId(idMarker);
		setName(title);
		this.description = description;
		this.imageUrl = imageUrl;
		this.iconUrl = iconUrl;
		this.latitude = latitude;
		this.longitude = longitude;
		this.site = site;
		this.routeStr = routeStr;
		this.fk_category = fk_category;
		this.address = address;
	}

	public int compareTo(Marker m2) {
		Marker m1 = this;
		int res = String.CASE_INSENSITIVE_ORDER.compare(m1.getName(),
				m2.getName());
		if (res == 0) {
			res = m1.getName().compareTo(m2.getName());
		}
		return res;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getRouteStr() {
		return routeStr;
	}

	public void setRouteStr(String routeStr) {
		this.routeStr = routeStr;
	}

	public int getFk_category() {
		return fk_category;
	}

	public void setFk_category(int fk_category) {
		this.fk_category = fk_category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrs) {
		this.iconUrl = iconUrs;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
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