package com.chickenducks.weatherApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chickenducks.weatherApplication.Model.User;
import com.chickenducks.weatherApplication.repo.UserRepo;


//probably won't need

//@RestController
//@RequestMapping("/user")
//@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
//	@Autowired
//	private UserRepo repo;
//	
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody User userData){
//		System.out.println(userData);
//		User user = repo.findByUsername(userData.getUsername());
//		if(user.getPassword().equals(userData.getPassword())) {
//			return ResponseEntity.ok(user);
//		}
//		return (ResponseEntity<?>) ResponseEntity.internalServerError();
//	}


}
