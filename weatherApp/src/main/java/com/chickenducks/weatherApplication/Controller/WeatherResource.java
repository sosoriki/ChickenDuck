package com.chickenducks.weatherApplication.Controller;

import com.chickenducks.weatherApplication.Model.GeocoderResponse;
import com.chickenducks.weatherApplication.Model.User;
import com.chickenducks.weatherApplication.Model.WeatherResponse;
import com.chickenducks.weatherApplication.Model.Weather;
import com.chickenducks.weatherApplication.Service.WeatherService;
import com.chickenducks.weatherApplication.repo.UserRepo;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

@RestController
public class WeatherResource {
    private final WeatherService weatherServiceImpl;
    
    @Autowired
    public WeatherResource(WeatherService weatherService) {
        weatherServiceImpl = weatherService;
    }
    private static final String GEOCODEAPIKEY = "";
    private static final String WEATHERAPIKEY = "";


    /**
     * All-in-One controller
     * @param address place address
     * @return a weather report of the place
     */
    @GetMapping("/getWeather/location/{address}")
    public ResponseEntity<Weather> getWeather(@PathVariable String address ) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("maps/api/geocode/json")
                .queryParam("key", GEOCODEAPIKEY)
                .queryParam("address", address)
                .build();
        System.out.println(uri.toUriString());
        ResponseEntity<GeocoderResponse> response = new RestTemplate().getForEntity(uri.toUriString(), GeocoderResponse.class);
        //extract the lag lng from response from geocode api
        GeocoderResponse geocoderResponse = response.getBody();
        double lat = geocoderResponse.getResult()[0].getGeometry().getLocation().getLat();
        double lon = geocoderResponse.getResult()[0].getGeometry().getLocation().getLng();
        System.out.println("This lat:" + lat + " " + lon);
        ResponseEntity<WeatherResponse> weatherResponse = new RestTemplate().
                getForEntity("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + WEATHERAPIKEY + "&units=imperial", WeatherResponse.class);
        System.out.println(weatherResponse.toString());

        Weather weather = weatherServiceImpl.weather(weatherResponse);
        System.out.println(weather);
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }
    
    @Autowired
    private UserRepo repo;
	
	@PostMapping("/registerUser")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
		User newUser = new User();
		Optional<User> check = repo.findByUsername(user.getUsername());
		if(check.isPresent()) {
			System.out.println("Username exists!");
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encodedPassword);
        newUser.setAnswer(user.getAnswer());
        
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getPassword());
        System.out.println(newUser.getAnswer());
        System.out.println(newUser.getEnabled());
        
        repo.save(newUser);
         
        return new ResponseEntity<>(newUser, HttpStatus.OK);

		
    }
	
	@PutMapping("/registerAddress")
	public ResponseEntity<User> registerAddress(@RequestBody User user,User user2){
		User updateUser = repo.findByUsername(user.getUsername()).get();
		updateUser.setUser_id(updateUser.getUser_id());
		updateUser.setUsername(user.getUsername());
		updateUser.setPassword(updateUser.getPassword());
		updateUser.setRole(updateUser.getRole());
		updateUser.setAddress(user.getAddress());
		updateUser.setEnabled(updateUser.getEnabled());
		updateUser.setAnswer(updateUser.getAnswer());
		
		repo.save(updateUser);
		
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
	
	@PutMapping("/forgotPassword")
	public ResponseEntity<User> forgotPassword(@RequestBody User user){
		Optional<User> check = repo.findByUsername(user.getUsername());
		if(!check.isPresent()) {
			System.out.println("Username does NOT exist!");
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
		User updateUser = repo.findByUsername(user.getUsername()).get();
		System.out.println(user.getAnswer());
		System.out.println(updateUser.getAnswer());
		if(user.getAnswer().equals(updateUser.getAnswer())) {
			System.out.println(updateUser.getPassword());
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(user.getPassword());
	        System.out.println(encodedPassword);
			updateUser.setUser_id(updateUser.getUser_id());
			updateUser.setUsername(user.getUsername());
			updateUser.setPassword(encodedPassword);
			updateUser.setRole(updateUser.getRole());
			updateUser.setAddress(updateUser.getAddress());
			updateUser.setEnabled(updateUser.getEnabled());
			updateUser.setAnswer(updateUser.getAnswer());
			
			repo.save(updateUser);
			
			return new ResponseEntity<>(updateUser, HttpStatus.OK);
		}
		
		System.out.println("yo you failed");
		return new ResponseEntity<>(updateUser, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/forgotPasswordNoUsername")
	public ResponseEntity<User> forgotPasswordNoUsername(@RequestBody User user){
		User updateUser = repo.findByUsername(user.getUsername()).get();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println("Old Password: " + updateUser.getPassword());
        System.out.println("New Password: " + encodedPassword);
        updateUser.setUser_id(updateUser.getUser_id());
		updateUser.setUsername(user.getUsername());
		updateUser.setPassword(encodedPassword);
		updateUser.setRole(updateUser.getRole());
		updateUser.setAddress(updateUser.getAddress());
		updateUser.setEnabled(updateUser.getEnabled());
		updateUser.setAnswer(updateUser.getAnswer());
		
		repo.save(updateUser);
        
        
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}



//
//    /**
//     * @param address place address
//     * @return a weather report of the place
//     */
//    @GetMapping("/getWeather/location/{address}")
//    public ResponseEntity<Weather> getWeather(@PathVariable String address ) {
//        UriComponents uri = UriComponentsBuilder.newInstance()
//                .scheme("http")
//                .host("localhost:8080")
//                .path("getWeather")
//                .queryParam("address", address)
//                .build();
//        System.out.println(uri.toUriString());
//        // calling /getweather interface in GeocodeApiController
//        ResponseEntity<WeatherResponse> weatherResponse = new RestTemplate().getForEntity(uri.toUriString(), WeatherResponse.class);
//        System.out.println(weatherResponse.getBody().toString());
//        Weather weather = weatherServiceImpl.weather(weatherResponse);
//        System.out.println(weather.toString());
//        return new ResponseEntity<Weather>(weather, HttpStatus.OK);
//    }

}
