package org.headroyce.AngoPets;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
         * @param primaryStage
         * @throws Exception
         */
        public void start(Stage primaryStage) throws Exception {
            GameGUI root = new GameGUI();
            primaryStage.setTitle("AngoPets");
            Scene scene = new Scene(root, 600.0D, 600.0D);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        /**
         * Main method to execute the program
         */
        public static void main(String[] args) {
            launch(args);
        }

    }
