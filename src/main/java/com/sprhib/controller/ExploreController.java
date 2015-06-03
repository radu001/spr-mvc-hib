package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.service.CategoryService;
import com.sprhib.service.MarkerService;
import com.sprhib.vo.MarkerVO;

@Controller
@RequestMapping(value="/explore")
public class ExploreController {

	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/explorePage")
	public ModelAndView loadExplorerPage() {
		ModelAndView modelAndView = new ModelAndView("explore");
		modelAndView.addObject("categories", categoryService.getAll());	
		return modelAndView;
	}
	
	@RequestMapping(value="/listJson/{id}")
	public  @ResponseBody  List<MarkerVO> listOfMarkersJson(@PathVariable String id) {
		
		int categoryIdInt = Integer.parseInt(id);
		
		List<MarkerVO> markers = null;
		if (categoryIdInt != -1)
			markers = markerService.getByFK(categoryIdInt);
		else
			markers = markerService.getAll();
		
		
		return markers;
	}
	
	
}
