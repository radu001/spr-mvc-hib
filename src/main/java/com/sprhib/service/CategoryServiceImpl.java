package com.sprhib.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.CategoryDao;
import com.sprhib.model.MarkersCategory;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	public int insert(MarkersCategory object) {
		return categoryDao.insert(object);
	}
	
	public MarkersCategory getByPK(int key) {
		return categoryDao.getByPK(key);
	}

	public void update(MarkersCategory object) {
		categoryDao.update(object);
	}
	
	public void delete(MarkersCategory object) {
		categoryDao.delete(object);
	}
	
	public List<MarkersCategory> getAll() {
		return categoryDao.getAll();
	}
	
	public Long getCount() {
		return categoryDao.getCount();
	}
}