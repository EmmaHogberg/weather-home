package com.emma.weatherhome;

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.IOException;

public class ViewGUI {

    // Position for text
    private final static int textLeftMargin = 80;

    // Size variables for button
    private final static int buttonHeight = 40;
    private final static int buttonWidth = 125;
    private final static int buttonFontSize = 15;

    public static Pane getPaneView(WeatherBean weatherBean) {

        // Set text
        Text header = new Text("Your Weather Home App");
        header.setFont(new Font(31));
        header.setY(60);
        header.setX(textLeftMargin);
        Text weather = new Text("Weather in " + weatherBean.getLocation() + ": " + weatherBean.getMainWeather() + " with " + weatherBean.getWeatherDescription());
        weather.setFont(new Font(17));
        weather.setY(120);
        weather.setX(textLeftMargin);
        Text tempIndoor = new Text("Indoors: " + weatherBean.getIndoorTemp() + " ℃");
        tempIndoor.setFont(new Font(17));
        tempIndoor.setY(150);
        tempIndoor.setX(textLeftMargin);
        Text tempOutdoor = new Text("Outdoors: " + weatherBean.getOutdoorTemp() + " ℃");
        tempOutdoor.setFont(new Font(17));
        tempOutdoor.setY(180);
        tempOutdoor.setX(textLeftMargin);
        Text info = new Text ("Blinds: The temperature is under 22 ℃ and the weather\nis not too sunny so the blinds are open");
        info.setFont(new Font(13));
        info.setLayoutY(500);
        info.setLayoutX(textLeftMargin);

        // Visualisation of window with digital blinds
        Rectangle window = new Rectangle(50,50, 150, 200);
        window.setFill(Color.LIGHTBLUE);
        window.setStroke(Color.BLACK);
        window.setY(250);
        window.setX(175);

        // TODO Check weather and fix blinds
        Rectangle blind = new Rectangle(50,50, 140, 20);
        blind.setFill(Color.DARKGRAY);
        blind.setStroke(Color.BLACK);
        blind.setY(252);
        blind.setX(180);

        // Light buttons - cozyLighting
        ToggleButton cozyLighting = new ToggleButton("Cozy Lighting");
        cozyLighting.setFont(new Font(buttonFontSize));
        cozyLighting.setPrefSize(buttonWidth, buttonHeight);
        cozyLighting.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println(cozyLighting.getText() + " is " + newValue);
            try {
                HueHub.setLightState(cozyLighting.getText(), newValue);
                System.out.println("The light is changed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        // Light buttons - ceilingLamp
        ToggleButton ceilingLamp = new ToggleButton("Ceiling Lamp");
        ceilingLamp.setFont(new Font(buttonFontSize));
        ceilingLamp.setPrefSize(buttonWidth, buttonHeight);
        ceilingLamp.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println(ceilingLamp.getText() + " is " + newValue);
            try {
                HueHub.setLightState(ceilingLamp.getText(), newValue);
                System.out.println("The light is changed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        // Light buttons - decorationLight
        ToggleButton decorationLight = new ToggleButton("Decoration");
        decorationLight.setFont(new Font(buttonFontSize));
        decorationLight.setPrefSize(buttonWidth, buttonHeight);
        decorationLight.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println(decorationLight.getText() + " is " + newValue);
            try {
                HueHub.setLightState(decorationLight.getText(), newValue);
                System.out.println("The light is changed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        // Add to HBox
        HBox hbox = new HBox(cozyLighting, ceilingLamp, decorationLight);
        hbox.setLayoutX(62);
        hbox.setLayoutY(600);

        // Add to pane
        Pane pane = new Pane();
        pane.getChildren().add(header);
        pane.getChildren().add(weather);
        pane.getChildren().add(tempIndoor);
        pane.getChildren().add(tempOutdoor);
        pane.getChildren().add(info);
        pane.getChildren().add(window);
        pane.getChildren().add(blind);
        pane.getChildren().add(hbox);

        return pane;
    }
}
