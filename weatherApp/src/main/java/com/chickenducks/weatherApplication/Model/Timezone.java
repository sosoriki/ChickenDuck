package com.chickenducks.weatherApplication.Model;

public class Timezone {
    private String timeZoneId;

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    @Override
    public String toString() {
        return "Timezone{" +
                "timeZoneId='" + timeZoneId + '\'' +
                '}';
    }
}
