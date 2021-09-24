package com.emma.weatherhome;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {



    public static void main(String[] args) throws IOException {

        // Variabler
        String apiEndPoint = "http://api.openweathermap.org/data/2.5/weather?";
        String location = "q=London";
        String units = "units=metric";
        String apiKey = "appid=2829f6ac8b6bc92596d71b9760aeb5a9";


        // Request
        URL url = new URL(apiEndPoint + location + "&" + units + "&" + apiKey);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Accept", "application/json");

        System.out.println();
        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();
    }
}
