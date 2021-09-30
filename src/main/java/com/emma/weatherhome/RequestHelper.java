package com.emma.weatherhome;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RequestHelper {

    public static JSONObject getJsonFromApi(String urlString) throws IOException {

        URL url = new URL(urlString);

        // Request
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();

        // Handle response
        if (responseCode != 200) {
            conn.disconnect();
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        }

        Scanner scanner = new Scanner(url.openStream());
        StringBuilder inline = new StringBuilder();

        while (scanner.hasNext()) {
            inline.append(scanner.nextLine());
        }
        scanner.close();
        conn.disconnect();

        // String to JsonObject
        Object dataObject = JSONValue.parse(String.valueOf(inline));

        return (JSONObject) dataObject;
    }



}
