package org.headroyce.AngoPets;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Driver to start the JavaFX program
 */
public class Main extends Application {

    public Main() {
    }

    /**
     * Start method where you start on a Settings scene
     *
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception {
        GameGUI root = new GameGUI();
        primaryStage.setTitle("AngoPets");
        Scene scene = new Scene(root, 600.0D, 600.0D);
        primaryStage.setScene(scene);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                root.handleKeyPress(keyEvent);
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                root.handleKeyRelease(keyEvent);
            }
        });
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.handleMouseClick(mouseEvent);
            }
        });
        primaryStage.show();
    }

    /**
     * Main method to execute the program
     */
    public static void main(String[] args) {
        launch(args);
    }


}

