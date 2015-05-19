package com.sprhib.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.MarkerDao;
import com.sprhib.model.Marker;

@Service
@Transactional
public class MarkerServiceImpl implements MarkerService{

	@Autowired
	private MarkerDao markerDao;
	
	public int insert(Marker object) {
		markerDao.insert(object);
		return 1;
	}
	
	public Marker getByPK(int key) {
		return markerDao.getByPK(key);
	}
	
	public void update(Marker object) {
		markerDao.update(object);
	}
	
	public void delete(Marker object) {
		markerDao.delete(object);	
	}
	
	public List<Marker> getAll() {
		return markerDao.getAll();
	}
	
	public List<Marker> getByFK(int fk) {
		return markerDao.getByFK(fk);
	}

	public Long getCount() {
		return markerDao.getCount();
	}

}