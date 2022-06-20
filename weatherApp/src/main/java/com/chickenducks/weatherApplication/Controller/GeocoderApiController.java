package com.chickenducks.weatherApplication.Controller;

import com.chickenducks.weatherApplication.Model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class GeocoderApiController {

    //get API key from google doc and remember to remove when push
    private static final String APIKEY = "";

    @GetMapping("/test")
    public String test() {
        return "service up";
    }


    /**
     * @param address place address
     * @return  address,latitude,longitude of the place
     */
    @GetMapping("/getLocation")
    public GeocoderResponse getGeoDetails(@RequestParam String address) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("maps/api/geocode/json")
                .queryParam("key", APIKEY)
                .queryParam("address", address)
                .build();
        //System.out.println(uri.toUriString());
        ResponseEntity<GeocoderResponse> response = new RestTemplate().getForEntity(uri.toUriString(), GeocoderResponse.class);
        return response.getBody();
    }

    /**
     * @param address place address
     * @return the coordinate,condition,temperature of the place
     */
    @GetMapping("/getWeather")
    public WeatherResponse getWeather(@RequestParam String address) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("maps.googleapis.com")
                .path("maps/api/geocode/json")
                .queryParam("key", APIKEY)
                .queryParam("address", address)
                .build();
        // Calling getlocation in GeocoderApiController, receiving GeocoderResponse
        ResponseEntity<GeocoderResponse> response = new RestTemplate().getForEntity(uri.toUriString(), GeocoderResponse.class);
        GeocoderResponse geocoderResponse = response.getBody();
        double lat = geocoderResponse.getResult()[0].getGeometry().getLocation().getLat();
        double lon = geocoderResponse.getResult()[0].getGeometry().getLocation().getLng();
        System.out.println("This lat:" + lat + " " + lon);
        // Calling getWeatherApi in WeatherApiController, receiving weatherResponse
        ResponseEntity<WeatherResponse> weatherResponse = new RestTemplate().getForEntity("http://localhost:8080/getWeatherApi/lat=" + lat + "&lon=" + lon, WeatherResponse.class);
        weatherResponse.getBody().setFormattedAddress(response.getBody().getResult()[0].getAddress());
        return weatherResponse.getBody();
    }

}
