package ru.szhernovoy.fx;/**
 * Created by Sergey on 25.04.2017.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyHello extends Application {

    @Override
    public void start(Stage primaryStage) {


        TextField textField = new TextField();

        Text msg = new Text();
        Button btn = new Button();
        btn.setText("Say hello!!!");

        btn.setOnAction(event -> {
            String message = textField.getText();
            if(message.isEmpty()){
                msg.setText("Hello, Sergey !!!");
            } else {
                msg.setText(message);
            }
        });


        VBox vBox = new VBox();
        vBox.getChildren().addAll(msg,textField,btn);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox,350,350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFx my expireince");
        primaryStage.show();
    }

//    public static void main(String[] args) {
//        launch(args);
//    }



}
