package lesson1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;


public class Sample extends Pane{

	@FXML
	private Label label;

	@FXML
	public void handleBtnAction(ActionEvent actionEvent) {
		System.out.println("You clicked me");
		label.setText("Hello world !!!");
	}
}
