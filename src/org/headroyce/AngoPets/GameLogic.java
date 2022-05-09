package org.headroyce.AngoPets;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the logic of the game
 */
public class GameLogic {
    private Random rand;
    private ArrayList<Button> buttons;
    private GameTimer gameTimer;
    private double canvasWidth, canvasHeight;
    private int int1, int2;
    private String operation, playString;
    private AngoPet genderNeutralAngopet;
    private Stage stage;

    public GameLogic() {
        stage = new Stage();
        buttons = new ArrayList<>();
        rand = new Random();
        gameTimer = new GameTimer();
        genderNeutralAngopet = new Snake(70, 70);
        int1 = rand.nextInt(10);
        int2 = rand.nextInt(10);
        operation = "add";
        playString = "";
        gameTimer.start();
    }

    /**
     * Checks for when a button is clicked
     * @param mouseEvent the cursor clicking the button
     */
    public void click(MouseEvent mouseEvent) {
        if (mouseEvent.getX() >= genderNeutralAngopet.getX() && mouseEvent.getX() <= genderNeutralAngopet.getX() + genderNeutralAngopet.getWidth() && mouseEvent.getY() >= genderNeutralAngopet.getY() && mouseEvent.getY() <= genderNeutralAngopet.getY() + genderNeutralAngopet.getHeight()) {
            genderNeutralAngopet.setXSpeed(2);
            genderNeutralAngopet.setYSpeed(2);
        }

        for(int i = 0; i < buttons.size(); i++) {
            if (isWithin(mouseEvent.getX(), mouseEvent.getY(), buttons.get(i))) {
                buttons.get(i).click();
            }
        }
    }

    /**
     *
     * @param x
     * @param y
     * @param button
     * @return
     */
    public boolean isWithin(double x, double y, Button button) {
        if (x >= button.getX() && x <= button.getX() + button.getWidth() && y >= button.getY() && y <= button.getY() + button.getHeight()) {
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
            for(int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isOn()) {
                    stage.setSet(buttons.get(i).getStage());
                }
            }
            if (stage.getSet() == "Play") {
                if (playString == "") {
                    if (genderNeutralAngopet.getAge() < 5) {
                        int1 = rand.nextInt(10);
                        int2 = rand.nextInt(10);
                        operation = "+";
                    }
                    if (genderNeutralAngopet.getAge() > 5 && genderNeutralAngopet.getAge() < 15) {
                        int1 = rand.nextInt(20);
                        int2 = rand.nextInt(20);
                        operation = "-";
                    }
                    playString = int1 +" " + operation + " " + int2 + " =";
                    stage.setPlayString(playString);
                }
            }

        }
    }

    /**
     * Renders the game elements onto a canvas
     * @param canvas the canvas to render onto
     */
    public void render(Canvas canvas) {
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        stage.render(canvas);
        buttons = stage.getButtons();
        for(int i = 0; i < buttons.size(); i++) {
            buttons.get(i).render(canvas);
        }
        if (stage.getSet() == "StartingScreen") {
            genderNeutralAngopet.render(canvas);
        }

    }

}
