package com.chickenducks.weatherApplication.Contoller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chickenducks.weatherApplication.bean.AuthenticationBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class BasicAuthController {
	
	 @GetMapping(path = "/basicauth")
	 public AuthenticationBean basicauth() {
		 System.out.printf("Success");
	     return new AuthenticationBean("You are authenticated");
	 }

}
