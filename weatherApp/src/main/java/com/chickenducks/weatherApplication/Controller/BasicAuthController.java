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
//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/greeting")
//    public String greeting() {
//
//        //return new Greeting(counter.incrementAndGet(), String.format(template, name));
//        return "Hello,greeting";
//    }
}
