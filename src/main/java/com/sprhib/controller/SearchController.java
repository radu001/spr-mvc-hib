package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.service.MarkerService;
import com.sprhib.vo.MarkerVO;

@Controller
public class SearchController {
	
	@Autowired
	private MarkerService markerService;
	
	
	List<MarkerVO> markers = null;
	
	@RequestMapping(value="/search")
	public ModelAndView nullSearchPage() {
		markers = null;
		ModelAndView modelAndView = new ModelAndView("search");
		modelAndView.addObject("notFound", "not found");
		return modelAndView;
	}
	
	@RequestMapping(value="/search/{searchStr}")
	public ModelAndView loadSearchPage(@PathVariable String searchStr) {
		markers = null;
		ModelAndView modelAndView = new ModelAndView("search");
		
		if(searchStr.isEmpty()) {
			modelAndView.addObject("notFound", "not found");
			return modelAndView;
		}
		
		markers = markerService.search(searchStr);
		
		if(markers.isEmpty()) {
			modelAndView.addObject("notFound", "not found");
			return modelAndView;		
		}
				
		return modelAndView;
	}
	
	
	@RequestMapping(value="/search/listJson/")
	public  @ResponseBody  List<MarkerVO> listOfMarkersJson() {
		return markers;
	}

}
