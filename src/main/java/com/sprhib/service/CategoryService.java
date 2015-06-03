package com.sprhib.service;


import java.util.List;

import com.sprhib.model.MarkersCategory;
import com.sprhib.vo.MarkersCategoryVO;

public interface CategoryService {

	public int insert(MarkersCategory object);

	public MarkersCategoryVO getByPK(int key);

	public void update(MarkersCategory object);

	public void delete(MarkersCategory object);

	public List<MarkersCategoryVO> getAll();

	Long getCount();
	
}