package lesson5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomJavaFXItem extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();
		VBox vBox = new VBox();

		Label label = new Label();
		label.setText("Test");
		label.getStyleClass().add("rotate");
		RoundButton roundButton = new RoundButton(RoundButtonApi.PLUS);


		vBox.getChildren().add(label);
		vBox.getChildren().add(roundButton);
		root.getChildren().add(vBox);
		root.getStylesheets().add(CustomJavaFXItem.class.getClassLoader().getResource("css/default.css").toExternalForm());
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}
