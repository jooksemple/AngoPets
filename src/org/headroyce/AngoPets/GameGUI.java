package org.headroyce.AngoPets;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * Represents the Graphics of the game
 */
public class GameGUI extends StackPane {


    private Canvas gameArea;
    private GameLogic logic;
    private AnimationTimer animTimer;

    public GameGUI() {
        gameArea = new Canvas();
        gameArea.heightProperty().bind(this.heightProperty());
        gameArea.widthProperty().bind(this.widthProperty());

        animTimer = new AnimTimer();
        logic = new GameLogic();

        this.getChildren().add(gameArea);

        animTimer.start();
    }

    /**
     * handler for when the mouse is pressed on the screen, that passes the event to the logic click handler
     * @param mouseEvent the MouseEvent when the screen is clicked
     */
    public void handleMouseClick(MouseEvent mouseEvent) {
        logic.click(mouseEvent);
    }

    /**
     * handler for when the key is pressed on the screen, that passes the event to the logic key handler
     * @param event the KeyEvent when a key is pressed
     */
    public void handleKeyPress(KeyEvent event){
        logic.keyPress(event);
    }
    /**
     * handler for when the key is released on the screen, that passes the event to the logic key handler
     * @param event the KeyEvent when a key is pressed
     */
    public void handleKeyRelease(KeyEvent event){
        logic.keyRelease(event);
    }

    /**
     * The animation timer that runs render on logic and renders the canvas.
     */
    private class AnimTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
            GraphicsContext gc = gameArea.getGraphicsContext2D();
            gc.clearRect(0,0, gameArea.getWidth(), gameArea.getHeight());
                logic.render(gameArea);
            }
        }
}
