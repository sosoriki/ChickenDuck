package com.chickenducks.weatherApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
	
	@JsonProperty("formatted-address")
	private String address;
	private Geometry geometry;
	
	public String getAddress() {
		return address;
	}
	
	public Geometry getGeometry() {
		return geometry;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	

}
