package com.uk.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uk.shoppingbackend.dao.CategeoryDAO;
import com.uk.shoppingbackend.dto.CategeoryDTOBean;

@Controller
public class PageController {
	@Autowired
	private CategeoryDAO categeoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		try {
			mv.addObject("categeories", categeoryDAO.list());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact  us");
		mv.addObject("userClickContact", true);
		return mv;
	}

// To handle sidebar/navbar with categeory list dynamically
//	load all products / load products based on categeory
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All products");
//	    to show list of categeory
		mv.addObject("categeories", categeoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/categeory/{id}/products")
	public ModelAndView showCategeoryProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		// categeory DAo to fetch sinle categeory
		CategeoryDTOBean categeory = null;
		categeory = categeoryDAO.getCategeory(id);

		mv.addObject("title", categeory.getName());
//	    to show list of categeory
		
		mv.addObject("categeories", categeoryDAO.list());
		// to pass particular categeory
		
		mv.addObject("categeory", categeory);
		
		mv.addObject("userClickCategeoryProducts", true);
		return mv;
	}

//	@RequestMapping(value="/test2/{greeting}")
//	public ModelAndView test2(@PathVariable("greeting")String greeting)
//	{	if(greeting==null) {
//		greeting="This is default greetig value";
//	}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", greeting);
//		return mv;
//	}
}
