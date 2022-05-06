package org.headroyce.AngoPets;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class GameLogic {
    private Random rand;
    private GameTimer gameTimer;
    private double canvasWidth, canvasHeight;
    private Snake genderNeutralAngopet;

    public GameLogic() {
        rand = new Random();
        gameTimer = new GameTimer();
        genderNeutralAngopet = new Snake(70, 70);
        gameTimer.start();
    }
    public void click(MouseEvent mouseEvent) {
        if (isWithin (mouseEvent.getX(), mouseEvent.getY(), genderNeutralAngopet.getX(), genderNeutralAngopet.getY(), genderNeutralAngopet.getWidth(), genderNeutralAngopet.getHeight())) {
            genderNeutralAngopet.setXSpeed(2);
            genderNeutralAngopet.setYSpeed(2);
        }
    }
    public boolean isWithin(double x, double y, double boxX, double boxY, double boxWidth, double boxHeight) {
        if (x >= boxX && x <= boxX + boxWidth && y >= boxY && y <= boxY + boxHeight) {
            return true;
        }
        return false;
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
            genderNeutralAngopet.move();
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
        genderNeutralAngopet.render(canvas);
    }

}
