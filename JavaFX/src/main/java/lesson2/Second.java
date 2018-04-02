package lesson2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Observable;

public class Second extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		Text text1 = new Text();
		Button btn1 = new Button();
		text1.setText("Sample text");
		btn1.setText("Button");

		Text text2 = new Text();
		Button btn2 = new Button();
		text2.setText("Sample text");
		btn2.setText("Button");

		VBox root = new VBox();
		HBox row1 = new HBox();
		HBox row2 = new HBox();

		ObservableList<Node> nodes1 = row1.getChildren();
		nodes1.add(btn1);
		nodes1.add(text1);

		ObservableList<Node> nodes2 = row2.getChildren();
		nodes2.add(btn2);
		nodes2.add(text2);

		root.getChildren().add(row1);
		root.getChildren().add(row2);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}
