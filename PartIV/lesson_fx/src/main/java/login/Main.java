package login;/**
 * Created by Admin on 29.04.2017.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Main extends Application{
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginUIController loginPane = new LoginUIController();
        primaryStage.setScene(new Scene(loginPane));
        primaryStage.setTitle("Login Dialog Control");
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.show();
    }
}
