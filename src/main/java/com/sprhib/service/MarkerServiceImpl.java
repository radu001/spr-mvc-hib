package com.sprhib.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.MarkerDao;
import com.sprhib.model.Marker;
import com.sprhib.vo.MarkerVO;

@Service
@Transactional
public class MarkerServiceImpl implements MarkerService{

	@Autowired
	private MarkerDao markerDao;
	
	public int insert(Marker object) {
		markerDao.insert(object);
		return 1;
	}
	
	public MarkerVO getByPK(int key) {
		return new MarkerVO(markerDao.getByPK(key));
	}
	
	public void update(Marker object) {
		markerDao.update(object);
	}
	
	public void delete(Marker object) {
		markerDao.delete(object);	
	}
	
	public List<MarkerVO> getAll() {
		List<MarkerVO> markersVO = new ArrayList<MarkerVO>();
		List<Marker> list = markerDao.getAll();
		for(Marker marker : list)
			markersVO.add(new MarkerVO(marker));
		
		return markersVO;
	}
	
	public List<MarkerVO> getByFK(int fk) {		
		List<MarkerVO> markersVO = new ArrayList<MarkerVO>();
		for(Marker marker : markerDao.getByFK(fk))
			markersVO.add(new MarkerVO(marker));
		
		return markersVO;
	}

	public Long getCount() {
		return markerDao.getCount();
	}

}