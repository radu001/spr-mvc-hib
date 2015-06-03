
package com.sprhib.vo;

import com.sprhib.model.MarkersCategory;

public class MarkersCategoryVO {

	private int idCategory;
	private String name;
	private String description;

	public MarkersCategoryVO(MarkersCategory cat) {
		
		idCategory = cat.getIdCategory();
		name = cat.getName();
		description = cat.getDescription();
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
