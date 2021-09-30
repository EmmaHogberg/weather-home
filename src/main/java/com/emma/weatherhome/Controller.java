package com.emma.weatherhome;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller extends Application {
    private final static String LOCATION = "Arlöv";

    @Override
    public void start(Stage stage) throws IOException {

        WeatherBean weatherBean = WeatherRepository.getWeather(LOCATION);
        Scene scene = new Scene(ViewGUI.getPaneView(weatherBean), 500,700);
        stage.setTitle("Weather Home");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
