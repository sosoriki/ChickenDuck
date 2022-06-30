package com.chickenducks.weatherApplication.Model.forecastModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forecast implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

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
	private String deg;
	private double gust;

	private String date;
	private long dt;
	private String localTime;
	private String month;
	private String dateOfWeek;
	private int day;
	private String hour;
	private String shortTimezone;

	@Override
	public String toString() {
		return "Forecast{" +
				"latitude=" + latitude +
				", longitude=" + longitude +
				", temp=" + temp +
				", max_temp=" + max_temp +
				", min_temp=" + min_temp +
				", condition='" + condition + '\'' +
				", description='" + description + '\'' +
				", feels_like=" + feels_like +
				", pressure=" + pressure +
				", humidity=" + humidity +
				", iconUrl='" + iconUrl + '\'' +
				", speed=" + speed +
				", deg=" + deg +
				", gust=" + gust +
				", date='" + date + '\'' +
				", dt=" + dt +
				", localTime='" + localTime + '\'' +
				", month='" + month + '\'' +
				", dateOfWeek='" + dateOfWeek + '\'' +
				", day=" + day +
				", hour=" + hour +
				", shortTimezone='" + shortTimezone + '\'' +
				'}';
	}

	public String getShortTimezone() {
		return shortTimezone;
	}

	public void setShortTimezone(String shortTimezone) {
		this.shortTimezone = shortTimezone;
	}

	public String getDateOfWeek() {
		return dateOfWeek;
	}

	public void setDateOfWeek(String dateOfWeek) {
		this.dateOfWeek = dateOfWeek;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getLocalTime() {
		return localTime;
	}

	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getMax_temp() {
		return max_temp;
	}

	public void setMax_temp(double max_temp) {
		this.max_temp = max_temp;
	}

	public double getMin_temp() {
		return min_temp;
	}

	public void setMin_temp(double min_temp) {
		this.min_temp = min_temp;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getFeels_like() {
		return feels_like;
	}

	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	public String getDeg() {
		return deg;
	}

	public double getGust() {
		return gust;
	}

	public void setGust(double gust) {
		this.gust = gust;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
