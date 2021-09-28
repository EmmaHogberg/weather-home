package com.emma.weatherhome;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HueHub {

    public static void setLightState(boolean buttonPressed) throws IOException {

        String apiEndPoint = "https://hue.senth.org/api/";
        String hueUser = ConfigGateway.getHueUser();
        String cozyLighting = "lights/6/state";
        String bodyOn = "{\"on\":true}";
        String bodyOff = "{\"on\":false}";

        // Request
        URL url = new URL(apiEndPoint + hueUser + cozyLighting);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");

        OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

        if (buttonPressed) {
        }
        else if (!buttonPressed) {

        }

        osw.flush();
        osw.close();





    }




}
