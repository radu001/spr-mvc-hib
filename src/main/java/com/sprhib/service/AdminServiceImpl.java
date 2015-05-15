package com.sprhib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.AdminDao;
import com.sprhib.model.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDAO;

	public void updateAdmin(Admin admin) {
	adminDAO.updateAdmin(admin);
	}

	public Admin getAdmin() {
		return adminDAO.getAdmin();
	}

}