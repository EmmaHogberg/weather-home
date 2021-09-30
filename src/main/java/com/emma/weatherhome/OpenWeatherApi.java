package com.emma.weatherhome;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class OpenWeatherApi {

    public static OpenWeatherBean getWeatherForHome(String location) throws IOException, ParseException {

        // Variables
        String apiEndPoint = "http://api.openweathermap.org/data/2.5/weather?";
        String locationParam = "q=";
        String units = "units=metric";
        String apiKeyParam = "appid=";
        String paramDivider = "&";
        String apiKey = ConfigGateway.getOpenWeatherKey();
        OpenWeatherBean weatherBean = new OpenWeatherBean();

        // Build URL
        String urlString = apiEndPoint +
                locationParam +
                location +
                paramDivider +
                units +
                paramDivider +
                apiKeyParam +
                apiKey;

        // Request
        JSONObject jsonData = RequestHelper.getJsonFromApi(urlString);

        // Get object "main" and get the parameter "temp" from it
        JSONObject mainJson = (JSONObject) jsonData.get("main");
        String temp = mainJson.get("temp").toString();
        weatherBean.setOutdoorTemp(temp);
        System.out.println("Outdoor temp: " + temp);

        // Get main weather and weather description
        JSONArray jsonWeatherArray = (JSONArray) jsonData.get("weather");
        JSONObject obj = (JSONObject) jsonWeatherArray.get(0);
        String mainWeather = (String) obj.get("main");
        weatherBean.setMainWeather(mainWeather);
        String description = (String) obj.get("description");
        weatherBean.setWeatherDescription(description);
        System.out.println("Weather: " + mainWeather + " - " + description);

        return weatherBean;
    }
}