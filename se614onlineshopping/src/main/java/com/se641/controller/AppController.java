/**
 * 
 */
package com.se641.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.se641.se641backend.dao.CategoryDao;
import com.se641.se641backend.model.Category;

/**
 * @author zknabi
 *
 */
@Controller
public class AppController {

	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index"); // app.jsp
		mv.addObject("pageTitle", "Home");

		// Getting work through and pass to the page
		mv.addObject("categories", categoryDao.categoryList());
		mv.addObject("userClickHome", true);

		return mv;

	}

	/*
	 * Load all products and show them by category
	 * 
	 */

	@RequestMapping(value = {"/view/all/products"})
	public ModelAndView viewAllTheProducts() {
		ModelAndView mv = new ModelAndView("index"); // app.jsp
		mv.addObject("pageTitle", "All Products");

		// Getting work through and pass to the page
		mv.addObject("categories", categoryDao.categoryList());
		mv.addObject("userClickAllProducts", true);

		return mv;

	}

	@RequestMapping(value = {"/view/category/{id}/products"})
	public ModelAndView viewCategoryProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("index"); // app.jsp

		// getting category name in categoryDao
		Category category = null;
		category = categoryDao.get(id);

		mv.addObject("pageTitle", category.getName());
		
		mv.addObject("categories", categoryDao.categoryList()); // Getting work through and pass to the page
		mv.addObject("category", category); // pass single category
		mv.addObject("userClickCategoryProducts", true);

		return mv;

	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("pageTitle", "Contact us");
		mv.addObject("userClickContact", true);

		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("pageTitle", "About us");
		mv.addObject("userClickAbout", true);

		return mv;
	}

}
