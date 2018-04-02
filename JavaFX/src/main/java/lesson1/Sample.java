package lesson1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;


public class Sample  implements Initializable {

	private StringProperty stringProperty = new SimpleStringProperty("Hello world");

	public String getStringProperty() {
		return stringProperty.get();
	}

	public StringProperty stringPropertyProperty() {
		return stringProperty;
	}

	public void setStringProperty(String stringProperty) {
		this.stringProperty.set(stringProperty);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
