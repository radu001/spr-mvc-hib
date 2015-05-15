package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Marker;

public interface MarkerService {

	public int insert(Marker object);

	public Marker getByPK(int key);

	public void update(Marker object);

	public void delete(Marker object);

	public List<Marker> getAll();
	
	public List<Marker> getByFK(int fk);

	Long getCount();
	
}
