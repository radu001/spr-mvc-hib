package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Marker;

@Repository
public class MarkerDaoImpl implements MarkerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	public int insert(Marker object) {
		getCurrentSession().save(object);
		return 1;
	}

	
	public Marker getByPK(int key) {
		Marker marker = (Marker) getCurrentSession().get(Marker.class, key);
		return marker;
	}

	
	public void update(Marker object) {
		getCurrentSession().update(object);
	}

	
	public void delete(Marker object) {
		Marker marker = getByPK(object.getId());
		if (marker != null)
			getCurrentSession().delete(marker);
	}

	@SuppressWarnings("unchecked")
	public List<Marker> getAll() {
		return getCurrentSession().createQuery("from marker").list();
	}

	
	public Long getCount() {
		Long count = (Long) getCurrentSession().createQuery("select count(*) from marker").uniqueResult();
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Marker> getByFK(int fk) {
		return getCurrentSession().createQuery("select * from marker as marker where marker.fk_category=:fk_category")
        .setParameter("fk_category",fk).list(); 
	}
}