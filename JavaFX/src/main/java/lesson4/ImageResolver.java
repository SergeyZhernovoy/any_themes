package lesson4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImageResolver extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Image image = new Image(ImageResolver.class.getClassLoader().getResource("images/858.jpg").toExternalForm());
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		imageView.setFitWidth(300);
		imageView.setPreserveRatio(true);
		StackPane root = new StackPane();
		root.getChildren().add(imageView);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}
}
