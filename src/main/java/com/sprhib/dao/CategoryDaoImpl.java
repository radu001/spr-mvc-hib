package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.MarkersCategory;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	public int insert(MarkersCategory object) {
		getCurrentSession().save(object);
		return 1;
	}

	
	public MarkersCategory getByPK(int key) {
		MarkersCategory category = (MarkersCategory) getCurrentSession().get(MarkersCategory.class, key);
		return category;
	}

	
	public void update(MarkersCategory object) {
		getCurrentSession().update(object);
	}

	
	public void delete(MarkersCategory object) {
		MarkersCategory category = getByPK(object.getId());
		if (category != null)
			getCurrentSession().delete(category);
	}

	@SuppressWarnings("unchecked")
	public List<MarkersCategory> getAll() {
		return getCurrentSession().createQuery("from category").list();
	}

	
	public Long getCount() {
		Long count = (Long) getCurrentSession().createQuery("select count(*) from category").uniqueResult();
		return count;
	}

}
