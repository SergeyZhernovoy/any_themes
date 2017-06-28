package fx;/**
 * @author Sergey Zhernovoy
 * create on 07.04.2017.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaFxlifeCycle extends Application {

    private static final Logger logger = LoggerFactory.getLogger(JavaFxlifeCycle.class);

    private StringProperty name = new SimpleStringProperty(this,"name","Sergey");


    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(String.format("start() method: %s",Thread.currentThread().getName()));
        Scene scene = new Scene(new Group(),200,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Life cycle JavaFX");
        primaryStage.show();

    }

    @Override
    public void init() throws Exception {
        Platform.setImplicitExit(true);
        System.out.println(String.format("init() method: %s",Thread.currentThread().getName()));
        System.out.println(name.getName() + " "+ name.getValue() );
    }

    @Override
    public void stop() throws Exception {

        System.out.println(String.format("stop() method: %s",Thread.currentThread().getName()));
    }
}

    