package com.sprhib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Admin;
import com.sprhib.service.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/admin")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("admin-info");
		
		Admin admin = adminService.getAdmin();

		modelAndView.addObject("admin", admin);
		
		return modelAndView;
	}
}
