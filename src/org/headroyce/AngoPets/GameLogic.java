package org.headroyce.AngoPets;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;

import java.util.Random;

public class GameLogic {
    private Random rand;
    private GameTimer gameTimer;
    private double canvasWidth, canvasHeight;
    private Snake genderneutralangopet;

    public GameLogic() {
        rand = new Random();
        gameTimer = new GameTimer();
        genderneutralangopet = new Snake(70, 70);
        gameTimer.start();
    }

    private class GameTimer extends AnimationTimer {
        // The last nanosecond
        private long lastUpdate;
        private long scoringUpdate;

        public GameTimer() {
            scoringUpdate = lastUpdate = 0;
        }

        @Override
        public void handle(long now) {
            genderneutralangopet.move();
            //TODO
        }
    }

    /**
     * Renders the game elements onto a canvas
     *
     * @param canvas the canvas to render onto
     */
    public void render(Canvas canvas) {
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        genderneutralangopet.render(canvas);
    }

}
