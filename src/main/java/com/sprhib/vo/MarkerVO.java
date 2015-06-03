package com.sprhib.vo;

import com.sprhib.model.Marker;


public class MarkerVO {

	private int idMarker;
	private String name;
	private String description;
	private String iconUrl;
	private double latitude;
	private double longitude;
	private String site;
	private int fk_category;
	private String route;
	private String imageUrl;
	private String address;
	
	public MarkerVO(Marker m) {
		idMarker = m.getIdMarker();
		name = m.getName();
		description = m.getDescription();
		iconUrl = m.getIconUrl();
		latitude = m.getLatitude();
		longitude = m.getLongitude();
		site = m.getSite();
		fk_category = m.getFk_category();
		route = m.getRoute();
		imageUrl = m.getImageUrl();
		address = m.getAddress();
	}
	
	public int getIdMarker() {
		return idMarker;
	}
	public void setIdMarker(int idMarker) {
		this.idMarker = idMarker;
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
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
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
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public int getFk_category() {
		return fk_category;
	}
	public void setFk_category(int fk_category) {
		this.fk_category = fk_category;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
