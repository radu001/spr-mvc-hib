package com.sprhib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Admin;
import com.sprhib.service.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginAdmin(HttpServletRequest request, @RequestParam("login") String login, @RequestParam("password") String password) {

		Admin admin = adminService.getAdmin();
	
		if (admin.getPassword().equals(password)
				&& login.equalsIgnoreCase("admin")) {
			request.getSession().setAttribute("loggedIn", true);
		}
	
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logoutAdmin(HttpServletRequest request) {
		
		if (request.getSession().getAttribute("loggedIn") != null) {
			request.getSession().removeAttribute("loggedIn");
		}
	
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}
}
