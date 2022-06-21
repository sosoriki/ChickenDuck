package com.chickenducks.weatherApplication.Controller;

import com.chickenducks.weatherApplication.AuthenticationBean;
import com.chickenducks.weatherApplication.Model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = "http://localhost:4200/main")
@RestController
@RequestMapping("/api/v1")
public class BasicAuthController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        System.out.println("check");

        return new AuthenticationBean("You are authenticated");
    }

}
