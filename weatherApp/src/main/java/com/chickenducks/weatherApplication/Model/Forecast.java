package com.chickenducks.weatherApplication.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forecast implements Serializable{
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private double temp;
	    private double max_temp;
	    private double min_temp;
	    private String condition;
	    private String description;
	    private String date;
	    private String formattedAddress;

	    public Forecast() {
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
	    
	    public String getDate() {
			return date;
		}


		public void setDate(String date) {
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
	        return "Forecast{" +
	                ", temp=" + temp +
	                ", max_temp=" + max_temp +
	                ", min_temp=" + min_temp +
	                ", condition='" + condition + '\'' +
	                ", description='" + description + '\'' +
	                ", formattedAddress='" + formattedAddress + '\'' +
	                '}';
	    }

	}
