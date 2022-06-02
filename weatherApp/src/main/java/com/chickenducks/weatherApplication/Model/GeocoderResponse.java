package com.chickenducks.weatherApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeocoderResponse {
	
	@JsonProperty("results")
	private Result[] result;

	public Result[] getResult() {
		return result;
	}

	public void setResult(Result[] result) {
		this.result = result;
	}
	

}
