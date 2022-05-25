package com.utilityFunction.app.utilityFunctionService.controllers.tinyurl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.utilityFunction.app.utilityFunctionService.model.url;
import com.utilityFunction.app.utilityFunctionService.repo.repo;

@RestController
public class tinyurlController {
	
	@Autowired
	private repo urlRepo;
	
	@GetMapping(value="/{tinyURL}")
	public Long getURL(@PathVariable url url){
		return url.getTinyURL();
	}
	
	@PostMapping(value="/create")
	public String createTinyURL(@RequestBody url url) {
		urlRepo.save(url);
		return "TinyURL created";
	}

}
