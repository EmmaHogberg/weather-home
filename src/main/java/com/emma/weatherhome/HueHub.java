package com.emma.weatherhome;

import org.json.simple.JSONObject;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HueHub {

    private final static String apiEndPoint = "https://hue.senth.org/api/";
    private final static String hueUser = ConfigGateway.getHueUser();

    // Make GET request to get state of sensor
    public static double getSensorTemperature() throws IOException {

        double temp;
        String sensorNumber = "/sensors/4";
        String urlString = apiEndPoint + hueUser + sensorNumber;

        // Make request
        JSONObject jsonData = RequestHelper.getJsonFromApi(urlString);

        JSONObject stateJson = (JSONObject) jsonData.get("state");
        temp = (Long) stateJson.get("temperature");
        temp = (temp / 100);
        System.out.println("Indoor temp: " + temp);
        return temp;
    }

    public static void setLightState(String lightName, boolean turnOnLight) throws IOException {

        switch (lightName) {
            case "Cozy Lighting" -> makeRequest("/lights/6/state", turnOnLight);
            case "Ceiling Lamp" -> makeRequest("/lights/16/state", turnOnLight);
            case "Decoration" -> makeRequest("/lights/7/state", turnOnLight);
        }
    }

    // Make PUT request to set state of lights
    private static void makeRequest(String lightNumber, boolean turnOnLight) throws IOException {

        URL url = new URL(apiEndPoint + hueUser + lightNumber);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

        // Write request body
        if (turnOnLight) {
            osw.write("{\"on\":true}");
            System.out.println(lightNumber + " On");
        }
        else {
            osw.write("{\"on\":false}");
            System.out.println(lightNumber + " Off");
        }
        osw.flush();
        osw.close();
        conn.getResponseCode();
        conn.disconnect();
    }
}
