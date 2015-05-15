package com.sprhib.service;

import java.util.List;

import com.sprhib.model.MarkersCategory;

public interface CategoryService {

	public int insert(MarkersCategory object);

	public MarkersCategory getByPK(int key);

	public void update(MarkersCategory object);

	public void delete(MarkersCategory object);

	public List<MarkersCategory> getAll();

	Long getCount();
	
}
