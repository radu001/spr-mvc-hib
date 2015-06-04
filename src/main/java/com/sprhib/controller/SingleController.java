package com.sprhib.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Marker;
import com.sprhib.model.MarkersCategory;
import com.sprhib.service.CategoryService;
import com.sprhib.service.MarkerService;
import com.sprhib.vo.MarkerVO;
import com.sprhib.vo.MarkersCategoryVO;

@Controller
public class SingleController {

	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/single/{id}", method=RequestMethod.GET)
	public ModelAndView singlePage(HttpServletRequest request, @PathVariable("id") Integer id) {

		ModelAndView modelAndView = new ModelAndView("single");
		
		MarkerVO marker = markerService.getByPK(id);
		modelAndView.addObject("marker",marker);
		
		if (request.getSession().getAttribute("loggedIn") != null) {		
			MarkersCategoryVO category = categoryService.getByPK(marker.getFk_category());
			List<MarkersCategoryVO> categories = categoryService.getAll();	
			modelAndView.addObject("category",category);
			modelAndView.addObject("categories",categories);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/single/listJson/{id}")
	public  @ResponseBody  MarkerVO markersJson(@PathVariable String id) {
		
		int idInt = Integer.parseInt(id);
		
		return markerService.getByPK(idInt);
	}
	
	@RequestMapping(value="/single/catJson/{id}")
	public  @ResponseBody  MarkersCategoryVO catJson(@PathVariable String id) {
		
		int idInt = Integer.parseInt(id);
		
		return categoryService.getByPK(idInt);
	}
	
	@RequestMapping(value="/single/updateCategory", method=RequestMethod.POST)
	public ModelAndView updateCategory(@ModelAttribute MarkersCategory category, @RequestParam String submitAction) {
		ModelAndView modelAndView = new ModelAndView("redirect:/explore/explorePage.html");
		
		if(submitAction.equals("update"))
			categoryService.update(category);
		else if(submitAction.equals("delete")) {
			List<MarkerVO> markers = markerService.getByFK(category.getIdCategory());
			for(MarkerVO m: markers){
				
				 File storeFile = new File("C:\\GitHub\\tmpFiles\\" + m.getImageUrl().substring(10));
		            if(storeFile.exists())
		            	if(storeFile.delete()){
		        			System.out.println("File is deleted!");
		        		}else{
		        			System.out.println("Delete operation is failed.");
		        		}
				
			}
			categoryService.delete(category);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/single/updateMarker", method=RequestMethod.POST)
	public ModelAndView updateMarker(@ModelAttribute Marker marker, @RequestParam String submitAction, @RequestParam("file") MultipartFile file) {
		
		File serverFile = null;
		String dateString = null;
        

		if(submitAction.equals("update")) {
			
	        if (!file.isEmpty()) {
	            try {

	                // Creating the directory to store file
	            	File dir = new File("C:\\GitHub" + File.separator + "tmpFiles");
	                if (!dir.exists())
	                    dir.mkdirs();
	 
	                Date date = new Date();
	                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
	                dateString = dateFormat.format(date);
	                
	                BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	                serverFile = new File(dir.getAbsolutePath()
	                        + File.separator + dateString + ".jpg");
	                ImageIO.write(src, "jpg", serverFile);
	                marker.setImageUrl("/tmpFiles/" + dateString + ".jpg");
	 
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        } else {
	            System.out.println("You failed to upload because the file was empty.");
	        }
			
		markerService.update(marker);
		
		}
		else if(submitAction.equals("delete"))  {
			System.out.println("C:\\GitHub\\tmpFiles\\" + marker.getImageUrl().substring(10));
	            File storeFile = new File("C:\\GitHub\\tmpFiles\\" + marker.getImageUrl().substring(10));
	            if(storeFile.exists())
	            	if(storeFile.delete()){
	        			System.out.println(file.getName() + " is deleted!");
	        		}else{
	        			System.out.println("Delete operation is failed.");
	        		}
	            markerService.delete(marker);
		}
		
		
		
		ModelAndView modelAndView = new ModelAndView("redirect:/explore/explorePage.html");
		
		return modelAndView;
	}
	
	
}
