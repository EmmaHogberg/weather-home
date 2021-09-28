package com.emma.weatherhome;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    private static String location = "Arlöv";

    @Override
    public void start(Stage stage) throws Exception {

        Text header = new Text("Your Weather Home App");
        header.setFont(new Font(30));
        header.setY(60);
        header.setX(90);
        Text weather = new Text("Weather in " + location + " is " );
        weather.setFont(new Font(17));
        weather.setY(120);
        weather.setX(120);
        Text temp = new Text("Temperature is ");
        temp.setFont(new Font(17));
        temp.setY(150);
        temp.setX(120);
        Text info = new Text("Information: The temperature is under 22, so the blinds are open");
        info.setY(210);
        info.setX(50);

        Rectangle window = new Rectangle(50,50, 150, 200);
        window.setFill(Color.LIGHTBLUE);
        window.setStroke(Color.BLACK);
        window.setY(300);
        window.setX(175);


        // TODO Check weather and fix blinds
        Rectangle blind = new Rectangle(50,50, 140, 20);
        blind.setFill(Color.DARKGRAY);
        blind.setY(302);
        blind.setX(180);



        // Light buttons
//        final ToggleGroup group = new ToggleGroup();
//        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//            @Override
//            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
//                System.out.println("LJUS!!!!");
//                System.out.println(t1.isSelected());
//            }
//        });

        ToggleButton cozyLighting = new ToggleButton("Cozy Lighting");
        cozyLighting.setFont(new Font(15));
        cozyLighting.setPrefSize(125, 40);
//        cozyLighting.setUserData("cozyLighting");
        cozyLighting.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println(cozyLighting.getText() + " is " + newValue);
            System.out.println("Taking a nap!");
        }));

        ToggleButton ceilingLamp = new ToggleButton("Ceiling Lamp");
        ceilingLamp.setFont(new Font(15));
        ceilingLamp.setPrefSize(125, 40);

        ToggleButton windowLight = new ToggleButton("Window Light");
        windowLight.setFont(new Font(15));
        windowLight.setPrefSize(125, 40);


        HBox hbox = new HBox(cozyLighting, ceilingLamp, windowLight);
        hbox.setLayoutX(62);
        hbox.setLayoutY(600);



        Pane pane = new Pane();
        pane.getChildren().add(header);
        pane.getChildren().add(weather);
        pane.getChildren().add(temp);
        pane.getChildren().add(info);
        pane.getChildren().add(window);
        pane.getChildren().add(blind);
        pane.getChildren().add(hbox);







        // Grid pane
//        GridPane gridPane = new GridPane();
//        gridPane.setMinSize(500, 800);
//        gridPane.setPadding(new Insets(10, 10, 10, 10));
//        gridPane.setVgap(10);
//        gridPane.setHgap(2);
//        gridPane.setAlignment(Pos.CENTER);
//
//        gridPane.add(header, 2, 0, 3,2);
//        gridPane.add(weather, 2,2);
//        gridPane.add(temp, 2,3);
//        gridPane.add(info, 2, 4);
//        gridPane.add(window, 1, 10);

//        ObservableList<Node> list = root.getChildren();
//        list.add(text);
        Scene scene = new Scene(pane, 500,700);

        stage.setTitle("Weather Home");
        stage.setScene(scene);
        stage.show();



    }


    public static void main(String[] args) throws IOException {
        launch(args);

        OpenWeatherApi.getWeatherForHome(location);
    }
}
