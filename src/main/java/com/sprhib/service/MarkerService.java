package com.sprhib.service;


import java.util.List;

import com.sprhib.model.Marker;
import com.sprhib.vo.MarkerVO;

public interface MarkerService {

	public int insert(Marker object);

	public MarkerVO getByPK(int key);

	public void update(Marker object);

	public void delete(Marker object);

	public List<MarkerVO> getAll();
	
	public List<MarkerVO> getByFK(int fk);

	Long getCount();
	
}