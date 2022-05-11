package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the Stages of the game
 */
public class Stage {
    private String set, playString;

    public Stage() {

        this.set = "StartingScreen";

    }

    /**
     * Sets the scene (what the canvas will look like)
     * @param set the scene to set to
     */
    public void setSet(String set) {
        this.set = set;
    }

    /**
     * Get the current scene the canvas is set to
     * @return the current scene
     */
    public String getSet() {
        return this.set;
    }

    /**
     * Sets the playString (the equation/expression to solve in Asteroids)
     * @param playString the new playString to set to
     */
    public void setPlayString(String playString) {
        this.playString = playString;
    }

    /**
     * Render these objects onto the canvas
     * @param canvas the canvas to render onto
     */
    public void render(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //what the play screen will look like
        if (set == "Play") {

            gc.setFill(Color.GREEN);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setFill(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            gc.fillText(playString, canvas.getWidth()/2, canvas.getHeight()/2);
        }
        //what the starting screen will look like
        if (set == "StartingScreen") {

            gc.setFill(Color.ALICEBLUE);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }

        //What the menu screen will look like
        if (set == "Menu") {
            gc.setFill(Color.RED);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }

    }
}
