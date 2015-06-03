
package com.sprhib.vo;

import com.sprhib.model.MarkersCategory;

public class MarkersCategoryVO {

	private int idCategory;
	private String name;
	private String description;
	private String iconUrl;


	public MarkersCategoryVO(MarkersCategory cat) {
		
		idCategory = cat.getIdCategory();
		name = cat.getName();
		description = cat.getDescription();
		iconUrl = cat.getIconUrl();
	}

	
	public String getIconUrl() {
		return iconUrl;
	}


	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}


	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
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
	
	
}
