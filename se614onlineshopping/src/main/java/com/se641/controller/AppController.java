/**
 * 
 */
package com.se641.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zknabi
 *
 */
@Controller
public class AppController {
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index"); //app.jsp
		String message = "Hi, Test!";
		mv.addObject("greeting", message);
		
		return mv;
		
		
	}

}
