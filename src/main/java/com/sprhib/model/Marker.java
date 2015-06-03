package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "marker")
public class Marker implements Comparable<Marker> {

	@Id
	@GeneratedValue
	private int idMarker;
	private String name;
	private String description;
	private double latitude;
	private double longitude;
	private String site;
	private int fk_category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_category", insertable = false, updatable = false)
	private MarkersCategory category;
	
	@Transient
	private String route;
	private byte[] routeByte;
	private String imageUrl;
	private String address;

	public Marker() {
		//convertRoute();
	}
	
	public void decode() {
		route = new String(Base64.decodeBase64(routeByte));
	}
	
	public void encode() {
		routeByte = Base64.encodeBase64(route.getBytes());
	}
	

	public MarkersCategory getCategory() {
		return category;
	}


	public void setCategory(MarkersCategory category) {
		this.category = category;
	}

	public Marker(int idMarker, String title, String description, String address, String imageUrl,
			String site, double latitude, double longitude, String routeStr, int fk_category) {
		setIdMarker(idMarker);
		setName(title);
		this.description = description;
		this.imageUrl = imageUrl;
		this.latitude = latitude;
		this.longitude = longitude;
		this.site = site;
		this.route = routeStr;
		this.fk_category = fk_category;
		this.address = address;
		//convertRoute();
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

	
	public byte[] getRouteByte() {
		return routeByte;
	}

	public void setRouteByte(byte[] routeByte) {
		this.routeByte = routeByte;
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

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
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

	
}