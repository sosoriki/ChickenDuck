package com.chickenducks.weatherApplication.Service;

import com.chickenducks.weatherApplication.Model.Timezone;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chickenducks.weatherApplication.Model.forecastModel.Forecast;
import com.chickenducks.weatherApplication.Model.forecastModel.ForecastResponse;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@Service
public class ForecastServiceImpl implements ForecastService{
	private double latitude;
	private double longitude;
	private double temp;
	private double max_temp;
	private double min_temp;
	private String condition;
	private String description;


	private double feels_like;
	private double pressure;
	private double humidity;
	private String iconUrl;
	private double speed;
	private double deg;
	private double gust;
	private static final String GEOCODEAPIKEY = "AIzaSyAQOMJ-2DMAH6B1ymW9rz__ScWIE4czcfI";
	@Override
	 public List<Forecast> forecast(ResponseEntity<ForecastResponse> forecastResponse) {
		List<Forecast> forecastList = new ArrayList<Forecast>();
		double lat = forecastResponse.getBody().getCity().getCoordinate().getLat();
		double lon = forecastResponse.getBody().getCity().getCoordinate().getLon();
		long timeStamp =  forecastResponse.getBody().getList()[0].getDt();
		String timezoneId = getTimezoneId(lat,lon,timeStamp);
		for (int i =0;i<40;i++) {
			Forecast forecast = new Forecast();
			long timeStamp_UTC =  forecastResponse.getBody().getList()[i].getDt();
			ZonedDateTime localTime = convertLocalTime(timezoneId,timeStamp_UTC);
			forecast.setMonth(localTime.format(DateTimeFormatter.ofPattern("MMM")));
			forecast.setDay(localTime.getDayOfMonth());
			forecast.setDateOfWeek(localTime.format(DateTimeFormatter.ofPattern("EEE")));
			forecast.setHour(localTime.format(DateTimeFormatter.ofPattern("h a")));
			String shortTimezone = TimeZone.getTimeZone(timezoneId)
					.getDisplayName(false, TimeZone.SHORT);
			forecast.setShortTimezone(shortTimezone);
			forecast.setLocalTime(localTime.format(DateTimeFormatter.ofPattern("MMM dd EEE")));
			forecast.setLatitude(forecastResponse.getBody().getCity().getCoordinate().getLat());
			forecast.setLongitude(forecastResponse.getBody().getCity().getCoordinate().getLon());
			forecast.setMax_temp(forecastResponse.getBody().getList()[i].getMain().getTemp_max());
			forecast.setMin_temp(forecastResponse.getBody().getList()[i].getMain().getTemp_min());
			forecast.setTemp(forecastResponse.getBody().getList()[i].getMain().getTemp());
			forecast.setCondition(forecastResponse.getBody().getList()[i].getCondition()[0].getMain());
			forecast.setDescription(forecastResponse.getBody().getList()[i].getCondition()[0].getDescription());
			//weather detail
			forecast.setDate(forecastResponse.getBody().getList()[i].getDate());
			forecast.setDt(forecastResponse.getBody().getList()[i].getDt());
			forecast.setDeg(convertDegreeToDirection(forecastResponse.getBody().getList()[i].getWind().getDeg()));
			forecast.setSpeed(forecastResponse.getBody().getList()[i].getWind().getSpeed());
			forecast.setGust(forecastResponse.getBody().getList()[i].getWind().getGust());
			forecast.setHumidity(forecastResponse.getBody().getList()[i].getMain().getHumidity());
			forecast.setFeels_like(forecastResponse.getBody().getList()[i].getMain().getFeels_like());
			forecast.setPressure(forecastResponse.getBody().getList()[i].getMain().getPressure());
			forecast.setHumidity(forecastResponse.getBody().getList()[i].getMain().getHumidity());
			forecast.setIconUrl("http://openweathermap.org/img/wn/"+forecastResponse.getBody().getList()[i].getCondition()[0].getIcon()+".png");
			forecastList.add(forecast);
		}
		 return forecastList;
	 }

	@Override
	public ZonedDateTime convertLocalTime(String timezoneId, long timestamp) {
		ZonedDateTime datetime=
				ZonedDateTime.ofInstant(Instant.ofEpochSecond(
						timestamp), ZoneId.of(timezoneId));
		return datetime;
	}



	@Override
	public String getTimezoneId(double lat, double lng, long timestamp) {
		//send the timestamp and lat&lng to timezone api to get a timezone Id back
		ResponseEntity<Timezone> tz = new RestTemplate().
				getForEntity("https://maps.googleapis.com/maps/api/timezone/json?location=" + lat +"," + lng + "&timestamp="+timestamp+"&key=" + GEOCODEAPIKEY, Timezone.class);
		String timezoneId = tz.getBody().getTimeZoneId();
		return timezoneId;
	}

	@Override
	public String convertDegreeToDirection(double degree) {
		 String[] directionArray = new String[]{"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N"};
		int index = (int) (degree% 360);
		index = (int) ((index/ 22.5));
		String compassDir = directionArray[index];
		return compassDir;


	}
}

