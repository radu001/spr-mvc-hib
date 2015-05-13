package com.sprhib.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/country")
public class CountryControler {
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String all(Model model){
		model.addAttribute("country1", "Moldova");
		return "allCountry";
	}
	
	@RequestMapping(value="/allListJSON", method=RequestMethod.GET)
	public  @ResponseBody List<String> gelAllName(){
		
		List<String> list = new ArrayList<String>();
		list.add("Moldova");
		list.add("Rominia");
		return list;
	}
	
	

}
