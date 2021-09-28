package com.emma.weatherhome;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.json.simple.parser.JSONParser;

import java.net.URL;
import java.util.Scanner;


public class OpenWeatherApi {

    public static void getWeatherForHome(String home) throws IOException {


        // Variabler
        String apiEndPoint = "http://api.openweathermap.org/data/2.5/weather?";
        String locationParam = "q=";
        String units = "units=metric";
        String apiKeyParam = "appid=";
        String paramDivider = "&";
        String apiKey = ConfigGateway.getOpenWeatherKey(); // TODO Är det onödigt att skapa key två gånger?

        // Build URL
        StringBuilder urlString = new StringBuilder();
        urlString.append(apiEndPoint);
        urlString.append(locationParam);
        urlString.append(home);
        urlString.append(paramDivider);
        urlString.append(units);
        urlString.append(paramDivider);
        urlString.append(apiKeyParam);
        urlString.append(apiKey);

        // Request
        URL url = new URL(urlString.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();

        System.out.println(url);

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            Scanner scanner = new Scanner(url.openStream());
            StringBuilder inline = new StringBuilder();
            while (scanner.hasNext()) {
                inline.append(scanner.nextLine());
            }
            System.out.println(inline);

        }
        System.out.println(conn.getResponseCode() + " " + conn.getResponseMessage());
        conn.disconnect();
    }




}
