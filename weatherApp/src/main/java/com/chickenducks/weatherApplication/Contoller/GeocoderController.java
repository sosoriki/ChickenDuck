package com.chickenducks.weatherApplication.Contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.chickenducks.weatherApplication.Model.GeocoderResponse;
import com.chickenducks.weatherApplication.Model.Response;

@RestController
public class GeocoderController {
	
	//get API key from google doc and remember to remove when push
	private static final String APIKEY = "";
	
	@GetMapping("/test")
	public String test() {
		return "service up";
	}
	
	@GetMapping("/getLocation")
	public GeocoderResponse getGeoDetails(@RequestParam String address) {
		UriComponents uri = UriComponentsBuilder.newInstance()
		.scheme("https")
		.host("maps.googleapis.com")
		.path("maps/api/geocode/json")
		.queryParam("key", APIKEY)
		.queryParam("address", address)
		.build();
		ResponseEntity<GeocoderResponse> response = new RestTemplate().getForEntity(uri.toUriString(), GeocoderResponse.class);
		return response.getBody();
	}
	
	@GetMapping("/getWeather")
	public Response getWeather(@RequestParam String address) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("maps.googleapis.com")
				.path("maps/api/geocode/json")
				.queryParam("key", APIKEY)
				.queryParam("address", address)
				.build();
		ResponseEntity<GeocoderResponse> response = new RestTemplate().getForEntity(uri.toUriString(), GeocoderResponse.class);
		GeocoderResponse coordinates = response.getBody();
		double lat = coordinates.getResult()[0].getGeometry().getLocation().getLatitude();
		double lon = coordinates.getResult()[0].getGeometry().getLocation().getLongitude();
		ResponseEntity<Response> weather = new RestTemplate().getForEntity("http://localhost:8080/getWeather/lat="+lat+"&lon"+lon, Response.class);
		return weather.getBody();
	}

}
