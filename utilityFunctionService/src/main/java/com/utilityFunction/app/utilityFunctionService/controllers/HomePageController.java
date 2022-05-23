package com.utilityFunction.app.utilityFunctionService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomePageController {
	
	@GetMapping(value = "/")
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("serviceApp/src/app/app.component.html");
		return modelAndView;
	}

}
