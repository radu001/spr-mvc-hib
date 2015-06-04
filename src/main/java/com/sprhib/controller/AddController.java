package com.sprhib.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Marker;
import com.sprhib.model.MarkersCategory;
import com.sprhib.service.CategoryService;
import com.sprhib.service.MarkerService;
import com.sprhib.vo.MarkersCategoryVO;

@Controller
public class AddController {
	

	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/add")
	public ModelAndView addPage() {
		ModelAndView modelAndView = new ModelAndView("add");
		List<MarkersCategoryVO> categories = categoryService.getAll();	
		MarkersCategoryVO category = categories.get(0);
		modelAndView.addObject("categories",categories);
		modelAndView.addObject("category",category);
		modelAndView.addObject("marker", new Marker());
		modelAndView.addObject("newCategory", new MarkersCategory());
		return modelAndView;
	}
	
	@RequestMapping(value="/add/addCategory", method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute MarkersCategory category) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/explore/explorePage.html");
		categoryService.insert(category);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/add/addMarker", method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute Marker marker, @RequestParam("file") MultipartFile file) {
         
		File serverFile = null;
		String dateString = null;
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
 
        

		ModelAndView modelAndView = new ModelAndView("redirect:/explore/explorePage.html");		
		markerService.insert(marker);
	
		return modelAndView;
	}
	
	
	
}
