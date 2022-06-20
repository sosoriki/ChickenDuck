package com.chickenducks.weatherApplication.Controller;

import com.chickenducks.weatherApplication.Model.GeocoderResponse;
import com.chickenducks.weatherApplication.Model.WeatherResponse;
import com.chickenducks.weatherApplication.Model.Weather;
import com.chickenducks.weatherApplication.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class WeatherResource {
    private final WeatherService weatherServiceImpl;

    @Autowired
    public WeatherResource(WeatherService weatherService) {
        weatherServiceImpl = weatherService;
    }
    private static final String GEOCODEAPIKEY = "";
    private static final String WEATHERAPIKEY = "";
    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<String>("Hello my friend, it is raining..", HttpStatus.OK);
        //return  ResponseEntity.ok("Hello my friend, it is raining..");
    }

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
        weatherResponse.getBody().setFormattedAddress(response.getBody().getResult()[0].getAddress());
        Weather weather = weatherServiceImpl.weather(weatherResponse);
        return new ResponseEntity<Weather>(weather, HttpStatus.OK);
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
