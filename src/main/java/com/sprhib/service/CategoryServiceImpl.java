package com.sprhib.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.CategoryDao;
import com.sprhib.model.MarkersCategory;
import com.sprhib.vo.MarkersCategoryVO;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	public int insert(MarkersCategory object) {
		return categoryDao.insert(object);
	}
	
	public MarkersCategoryVO getByPK(int key) {
		return new MarkersCategoryVO(categoryDao.getByPK(key));
	}

	public void update(MarkersCategory object) {
		categoryDao.update(object);
	}
	
	public void delete(MarkersCategory object) {
		categoryDao.delete(object);
	}
	
	public List<MarkersCategoryVO> getAll() {
		List<MarkersCategoryVO> categoryVO = new ArrayList<MarkersCategoryVO>();
		for(MarkersCategory category : categoryDao.getAll()) {
			categoryVO.add(new MarkersCategoryVO(category));
		}
		return categoryVO;
	}
	
	public Long getCount() {
		return categoryDao.getCount();
	}
}