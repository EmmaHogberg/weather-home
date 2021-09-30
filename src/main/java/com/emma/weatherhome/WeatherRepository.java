package com.emma.weatherhome;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class WeatherRepository {

    public static WeatherBean getWeather(String location) throws IOException {

        WeatherBean weatherBean = new WeatherBean();
        weatherBean.setLocation(location);
        weatherBean.setIndoorTemp(HueHub.getSensorTemperature());

        try {
            OpenWeatherBean openWeatherBean = OpenWeatherApi.getWeatherForHome(location);
            weatherBean.setMainWeather(openWeatherBean.getMainWeather());
            weatherBean.setWeatherDescription(openWeatherBean.getWeatherDescription());
            weatherBean.setOutdoorTemp(openWeatherBean.getOutdoorTemp());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return weatherBean;
    }
}
