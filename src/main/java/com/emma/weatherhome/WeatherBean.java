package com.emma.weatherhome;

public class WeatherBean {

    private String location;
    private String mainWeather;
    private String weatherDescription;
    private double indoorTemp;
    private String outdoorTemp;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMainWeather() {
        return mainWeather;
    }

    public void setMainWeather(String mainWeather) {
        this.mainWeather = mainWeather;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public double getIndoorTemp() {
        return indoorTemp;
    }

    public void setIndoorTemp(double indoorTemp) {
        this.indoorTemp = indoorTemp;
    }

    public String getOutdoorTemp() {
        return outdoorTemp;
    }

    public void setOutdoorTemp(String outdoorTemp) {
        this.outdoorTemp = outdoorTemp;
    }
}
