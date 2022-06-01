package com.chickenducks.weatherApplication.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderGeometry;
import com.google.code.geocoder.GeocoderRequestBuilder;

@Service
public class WeatherServiceImpl implements WeatherService {


    //TODO:get latitude,longitude from geocode API,collect data from Weather API

    @Override
    public double getLatitude(String zipcode) {
//    	final Geocoder geocoder = new Geocoder();
//    	GeocoderRequest request = new GeocoderRequestBuilder().setAddress(zipcode).getGeocoderRequest();
//    	GeocodeResponse response = geocoder.geocode(request);
//    	List<GeocoderResult> result = response.getResults();
//    	GeocoderResult data = result.get(0);
//    	GeocoderGeometry geo = data.getGeometry();
//    	double latitude = geo.getLocation().getLat().doubleValue();
//    	return latitude;
    	return -72.521;
    }

    @Override
    public double getLongitude(String zipcode) {
        return 66.0134;
    }

    @Override
    public Integer getMaxWeather(double latitude, double longitude) {
        return 90;
    }

    @Override
    public Integer getMinWeather(double latitude, double longitude) {
        return 80;
    }


}
