package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Marker;
import com.sprhib.model.MarkersCategory;
import com.sprhib.service.CategoryService;
import com.sprhib.service.MarkerService;

@Controller
public class AddController {

	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/add")
	public ModelAndView addPage() {
		ModelAndView modelAndView = new ModelAndView("add");
		List<MarkersCategory> categories = categoryService.getAll();	
		MarkersCategory category = categories.get(0);
		modelAndView.addObject("categories",categories);
		modelAndView.addObject("category",category);
		modelAndView.addObject("marker", new Marker());
		modelAndView.addObject("newCategory", new MarkersCategory());
		return modelAndView;
	}
	
	@RequestMapping(value="/add/addCategory", method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute MarkersCategory category) {
		
		System.out.println(category.getIdCategory() + category.getName() + category.getDescription());
		ModelAndView modelAndView = new ModelAndView("home");
		categoryService.insert(category);
		
		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/add/addMarker", method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute Marker marker) {
		
		System.out.println(marker.getIdMarker());
		ModelAndView modelAndView = new ModelAndView("home");
		markerService.insert(marker);
		
		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	
	
}