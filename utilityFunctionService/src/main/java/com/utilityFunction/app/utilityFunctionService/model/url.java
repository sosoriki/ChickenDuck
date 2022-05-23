package com.utilityFunction.app.utilityFunctionService.model;

import javax.persistence.*;

@Entity
public class url {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long originalURL;
	@Column
	private Long tinyURL;
	@Column
	private int timesAccessed;
	
	private Long getID() {
		return this.id;
	}
	
	private Long getOriginalURL() {
		return this.originalURL;
	}
	
	private Long gettinyURL() {
		return this.tinyURL;
	}
	
	private int getTimesAccessed() {
		return this.timesAccessed;
	}
	
	private void setID(Long id) {
		this.id = id;
	}
	
	private void setOriginalURL(Long originalURL) {
		this.originalURL = originalURL;
	}
	
	private void setTinyURL(Long tinyURL) {
		this.tinyURL = tinyURL;
	}
	
	private void setTimesAccessed(int timesAccessed) {
		this.timesAccessed = timesAccessed;
	}
}
