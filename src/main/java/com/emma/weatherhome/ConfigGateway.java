package com.emma.weatherhome;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ConfigGateway {

    // Method to get the Open Weather key from local document "ConfigKeys.json"
    public static String getOpenWeatherKey() {
        JSONParser parser = new JSONParser();
        String key = "";

        try (Reader reader = new FileReader("C:\\Users\\emz_d\\Desktop\\Grit Academy\\10-avancerad-javaprogrammering\\weather-home\\ConfigKeys.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            key = (String) jsonObject.get("openWeatherApiKey");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } return key;
    }

    // Method to get the Philips Hue username from local document "ConfigKeys.json"
    public static String getHueUser() {

        JSONParser parser = new JSONParser();
        String user = "";

        try (Reader reader = new FileReader("C:\\Users\\emz_d\\Desktop\\Grit Academy\\10-avancerad-javaprogrammering\\weather-home\\ConfigKeys.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            user = (String) jsonObject.get("hueUsername");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } return user;
    }
}
