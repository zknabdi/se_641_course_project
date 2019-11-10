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
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index"); //app.jsp
		String message = "Hi, Test!";
		mv.addObject("greeting", message);
		
		return mv;
		
		
	}
	
//	@RequestMapping(value="/test")
//	public ModelAndView test(@RequestParam(value="greeting", required = false)String greeting) 
//	{
//		if(greeting ==null) {
//			greeting = "Hello SE 641";
//		}
//		ModelAndView mv = new ModelAndView("index"); //app.jsp
//		mv.addObject("greeting", greeting);
//		
//		return mv;
//	}
	
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable(value="greeting")String greeting) 
	{
		if(greeting ==null) {
			greeting = "Hello SE 641";
		}
		ModelAndView mv = new ModelAndView("index"); //app.jsp
		mv.addObject("greeting", greeting);
		
		return mv;
	}
	
	
	

}
