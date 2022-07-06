package com.gd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		String message = "This is the Spring MVC Magic";
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("hellopage");
		modelAndView.addObject("thisIsModel", message);

		return modelAndView;
		
		//Else you can also write in singel line  as
		//return new ModelAndView("hellopage", "thisIsModel", message);
	}
	
	//http://localhost:8080/springmvc-hello-world/hi?user=GD
	@RequestMapping("/hi")
	@ResponseBody
	public String hi(@RequestParam String user) {
		return "Hi "+user+"!";
	}
	
	//Invocation url: localhost:8080/_15_sprinmvc-hello-using-maven/hi.html?user=gd
}
