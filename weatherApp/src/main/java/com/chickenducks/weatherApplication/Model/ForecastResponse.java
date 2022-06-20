package com.chickenducks.weatherApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class ForecastResponse {
	@JsonProperty("main")
	private Temperature temperature;
	@JsonProperty("weather")
	private Condition[] condition;
	@JsonProperty("dt_txt")
	private Date date;
	
	private String formattedAddress;
	
	public Temperature getTemperature() {
		return temperature;
	}
	
	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}
	
	public Condition[] getCondition() {
		return condition;
	}
	
	public void setCondition(Condition[] condition) {
		this.condition = condition;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }
	
	  @Override
	  public String toString() {
	    return "ForecastResponse{" +
	           ", condition=" + Arrays.toString(condition) +
	           ", temperature=" + temperature +
	           ", temperature=" + date +
	           ", formattedAddress='" + formattedAddress + '\'' +
	           '}';
	  }
}

