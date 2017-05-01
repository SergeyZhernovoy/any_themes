package ru.szhernovoy.login;/**
 * Created by Admin on 29.04.2017.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;

public class LoginUIController extends Pane {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private CheckBox rememberMeChk;

    @FXML
    private Label errorLbl;

    @FXML
    private Button resetBtn;

    @FXML
    private Button loginBtn;

    public LoginUIController() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginUI.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    @FXML
    void doCheck(ActionEvent event) {

    }

    @FXML
    void doLogin(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert loginTxt != null : "fx:id=\"loginTxt\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert passwordTxt != null : "fx:id=\"passwordTxt\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert rememberMeChk != null : "fx:id=\"rememberMeChk\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert errorLbl != null : "fx:id=\"errorLbl\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert resetBtn != null : "fx:id=\"resetBtn\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'LoginUI.fxml'.";

    }

}
