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
        if (set == "PlayOne") {

            gc.setFill(Color.PALETURQUOISE);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setFill(Color.BLACK);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            gc.fillText(playString + " (Click the right answer!)", canvas.getWidth()/2, canvas.getHeight()/2);
        }
        if (set == "PlayTwo") {
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
        //what the starting screen will look like
        if (set == "StartingScreen") {
            gc.setFill(Color.LIGHTBLUE);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }

        //What the menu screen will look like
        if (set == "Menu") {
            gc.setFill(Color.PALEGREEN);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setFill(Color.BLACK);
            gc.setTextAlign(TextAlignment.LEFT);
            gc.setTextBaseline(VPos.CENTER);
            gc.fillText(
                    "Hunger and Mood are essential to keeping your AngoPet alive!" +
                            "\n" + "\n" +
                            "If your AngoPet is in a bad mood, it will eat less, and if it gets hungry, it won't grow" + "\n" +
                            "and will eventually die! Take good care of it!" + "\n" + "\n" +
                            "Press “Play Hunger” to play the math game that feeds your AngoPet:\n" +
                    "\n" +
                    "Features of the Hunger Game:\n" +
                    "\n" +
                    "Try to click the correct answer to the math expression shown in the" +
                    "\n" +
                    "middle of the screen. If you click the right answer, it will disappear" +
                    "\n" +
                    "and tell you how much you fed your pet. There is no penalty for getting" + "\n"
                     + "the wrong answer. The amount that your pet is fed depends on its mood." + "\n" + "" +
                    "If your pet is sad, it will not eat any food. If your pet is angry, it gains" + "\n" +
                    "two hunger points when you feed it. If it is bored, it gains three hunger points," +"\n" +
                            "and if it is happy, it gains four hunger points." +
                    "\n" + "\n" +
                    "Press “Play Mood” to play the math game that improves the mood of your AngoPet:\n" +
                    "\n" +
                    "Features of the Mood Game:\n" + "\n" +
                    "You are in a spaceship, and you have to destroy the asteroids flying towards you!" + "\n" + "" +
                    "Use the arrow keys to navigate in your ship, and press space to launch a laser " + "\n" +
                    "projectile out from the front! To help your pet get happier, shoot down the wrong" + "\n" +
                    "answers to the math expression, and let the correct answers fall to the bottom of" + "\n" +
                    "the screen, or touch them with your spaceship. If you shoot the right answer or let" + "\n" +
                    "a wrong answer fall past you, the game is over and you are returned to the main screen.\n", 20, canvas.getHeight()/2);

        }

    }
}
