package com.sprhib.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Marker;
import com.sprhib.model.MarkersCategory;
import com.sprhib.service.CategoryService;
import com.sprhib.service.MarkerService;

@Controller
public class SingleController {

	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/single/{id}", method=RequestMethod.GET)
	public ModelAndView singlePage(HttpServletRequest request, @PathVariable("id") Integer id) {

		ModelAndView modelAndView = new ModelAndView("single");
		
		Marker marker = markerService.getByPK(id);
		modelAndView.addObject("marker",marker);
		
		if (request.getSession().getAttribute("loggedIn") != null) {		
			MarkersCategory category = categoryService.getByPK(marker.getFk_category());
			List<MarkersCategory> categories = categoryService.getAll();	
			modelAndView.addObject("category",category);
			modelAndView.addObject("categories",categories);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/single/listJson/{id}")
	public  @ResponseBody  Marker markersJson(@PathVariable String id) {
		
		int idInt = Integer.parseInt(id);
		
		return markerService.getByPK(idInt);
	}
	
	@RequestMapping(value="/single/catJson/{id}")
	public  @ResponseBody  MarkersCategory catJson(@PathVariable String id) {
		
		int idInt = Integer.parseInt(id);
		
		return categoryService.getByPK(idInt);
	}
	
	@RequestMapping(value="/single/updateCategory", method=RequestMethod.POST)
	public ModelAndView updateCategory(@ModelAttribute MarkersCategory category, @RequestParam String submitAction) {
		ModelAndView modelAndView = new ModelAndView("redirect:/explore/explorePage.html");
		
		if(submitAction.equals("update"))
			categoryService.update(category);
		else if(submitAction.equals("delete")) 
			categoryService.delete(category);

		return modelAndView;
	}
	
	@RequestMapping(value="/single/updateMarker", method=RequestMethod.POST)
	public ModelAndView updateMarker(@ModelAttribute Marker marker, @RequestParam String submitAction) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/explore/explorePage.html");
		if(submitAction.equals("update")) 
		markerService.update(marker);
		else if(submitAction.equals("delete")) 
			markerService.delete(marker);

		return modelAndView;
	}
	
	
}
