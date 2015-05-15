package com.sprhib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Admin;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void updateAdmin(Admin admin) {
		getCurrentSession().update(admin);
	}

	public Admin getAdmin() {
		Admin admin = (Admin) getCurrentSession().get(Admin.class, 666);
		return admin;
	}

}
