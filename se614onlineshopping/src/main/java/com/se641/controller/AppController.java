/**
 * 
 */
package com.se641.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zknabi
 *
 */
@Controller
public class AppController {

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index"); // app.jsp
		mv.addObject("pageTitle", "Home");
		mv.addObject("userClickHome", true);

		return mv;

	}

	@RequestMapping(value = { "/contact"})
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("pageTitle", "Contact us");
		mv.addObject("userClickContact", true);

		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("pageTitle", "About us");
		mv.addObject("userClickAbout", true);

		return mv;
	}

}
