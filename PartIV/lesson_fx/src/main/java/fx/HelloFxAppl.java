package fx;/**
 * Created by Sergey on 05.04.2017.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFxAppl extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Improved Java FX application");
        Text msg = new Text("Sergey Zhernovoy is a java developer");
        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e-> Platform.exit());
        VBox vBox = new VBox();

        Label nameLabel = new Label("Enter your name");
        TextField nameField = new TextField();
        Label msgLabel = new Label();
        msgLabel.setStyle("-fx-text-fill: blue");
        Button sayHello = new Button("Say hello");
        sayHello.setOnAction(e->{
            String name = nameField.getText();
            if(name.trim().length() > 0){
                msgLabel.setText(String.format("Hello %s",name));
            } else {
                msgLabel.setText("Hello there");
            }
        });

        vBox.setSpacing(5);
        vBox.getChildren().addAll(msg,nameLabel,nameField,sayHello,msgLabel,btnExit);

        Scene scene = new Scene(vBox,300,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
