package org.headroyce.AngoPets;

import javafx.animation.AnimationTimer;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

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

    private class AnimTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
            GraphicsContext gc = gameArea.getGraphicsContext2D();
            gc.clearRect(0,0, gameArea.getWidth(), gameArea.getHeight());
                logic.render(gameArea);
            }
        }
}
