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
	
	public Long getID() {
		return this.id;
	}
	
	public Long getOriginalURL() {
		return this.originalURL;
	}
	
	public Long getTinyURL() {
		return this.tinyURL;
	}
	
	public int getTimesAccessed() {
		return this.timesAccessed;
	}
	
	public void setID(Long id) {
		this.id = id;
	}
	
	public void setOriginalURL(Long originalURL) {
		this.originalURL = originalURL;
	}
	
	public void setTinyURL(Long tinyURL) {
		this.tinyURL = tinyURL;
	}
	
	public void setTimesAccessed(int timesAccessed) {
		this.timesAccessed = timesAccessed;
	}
}
