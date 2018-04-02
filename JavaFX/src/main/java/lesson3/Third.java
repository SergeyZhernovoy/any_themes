package lesson3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;

import java.awt.*;

public class Third extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Line line = new Line();
		line.setStartX(10);
		line.setStartY(10);
		line.setEndX(150);
		line.setEndY(150);
		line.setStroke(Color.TOMATO);

		Line line1 = new Line();
		line1.setStartX(150);
		line1.setStartY(10);
		line1.setEndX(10);
		line1.setEndY(150);
		line1.setStroke(Color.AQUA);

		primaryStage.setTitle("Hello world !!!");
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(event->System.out.println("Hello World !"));
		AnchorPane root = new AnchorPane();
		//root.getChildren().add(btn);
		//root.getChildren().add(line);
		//root.getChildren().add(line1);

		Polyline polyline = new Polyline();
		polyline.getPoints().addAll(new Double[] {
				10.0,10.0,10.0,100.0,100.0,100.0,100.0,10.0
		});
		polyline.setStroke(Color.TOMATO);
		polyline.setStrokeWidth(15);

		Rectangle rectangle = new Rectangle();
		rectangle.setX(50);
		rectangle.setY(50);
		rectangle.setWidth(100);
		rectangle.setHeight(150);
		rectangle.setFill(null);
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(5);

		root.getChildren().add(polyline);
		root.getChildren().add(rectangle);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}
