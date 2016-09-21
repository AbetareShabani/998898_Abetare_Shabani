package com.example.abetare.thoutside.Data;

import com.example.abetare.thoutside.Forecast;

/**
 * Created by Abetare on 9/20/2016.
 */
public class ForecastData {
    private String location;
    private String city;
    private String state;
    private float temp;
    private float humidity;
    private float pressure;
    private ForecastData(){}
    public ForecastData(float humidity, String location, String city, String state, float temp, float pressure) {
        this.humidity = humidity;
        this.location = location;
        this.city = city;
        this.state = state;
        this.temp = temp;
        this.pressure = pressure;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

}
