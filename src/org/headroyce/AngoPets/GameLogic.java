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
    private static final int STAT_TIMER = 1000;
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
        genderNeutralAngopet = new Snake(85, 70);
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
        private long statUpdate;

        public GameTimer() {
            statUpdate = lastUpdate = 0;
        }

        @Override
        public void handle(long now) {

            long scoring_time_elapsed = (now - lastUpdate) / 1000000;
            if (scoring_time_elapsed > STAT_TIMER) {
                genderNeutralAngopet.setAge(genderNeutralAngopet.getAge() + 1);
                genderNeutralAngopet.age(genderNeutralAngopet.getAge());
                statUpdate = now;
                lastUpdate = now;
            }
            genderNeutralAngopet.move();

            for(int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isOn()) {
                    stage.setSet(buttons.get(i).getStage());
                }
            }

            if (stage.getSet() == "StartingScreen") {
                buttons.clear();

                PlayButton e = new PlayButton(400, 50, 50, 20);
                e.setColor(Color.RED);
                e.setText("PLAY");
                buttons.add(e);

                MenuButton a = new MenuButton(100, 50, 50, 20);
                a.setColor(Color.RED);
                a.setText("MENU");
                buttons.add(a);
            }

                if (stage.getSet() == "Play") {
                    if (buttons.size() != 11) {
                        playString = "";
                        buttons.clear();
                        for (int i = 0; i < 10; i++) {
                            NumberButton e = new NumberButton();
                            e.setX(rand.nextInt((int) canvasWidth));
                            e.setY(-e.getHeight());
                            e.setColor(Color.RED);
                            e.setYSpeed(rand.nextDouble(5));
                            e.setXSpeed(rand.nextDouble(5) * 2 - 5);
                            buttons.add(e);
                        }
                        Button c = new Button(500, 20, 50, 20);
                        c.setText("Back");
                        c.setColor(Color.RED);
                        buttons.add(c);

                    }
                    for (int i = 0; i < buttons.size(); i++) {
                        if (buttons.get(i).getX() + buttons.get(i).getWidth() > canvasWidth) {
                            buttons.get(i).setXSpeed(Math.abs(buttons.get(i).getXSpeed()) * -1);
                        }
                        if (buttons.get(i).getX() < 0) {
                            buttons.get(i).setXSpeed(Math.abs(buttons.get(i).getXSpeed()));
                        }
                    }

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
                    if (genderNeutralAngopet.getAge() > 15 && genderNeutralAngopet.getAge() < 25) {
                        int1 = rand.nextInt(10);
                        int2 = rand.nextInt(10);
                        int op = rand.nextInt(2);
                        if (op == 1) {
                            operation = "*";
                        } else {
                            operation = "/";
                        }
                    }
                    if (genderNeutralAngopet.getAge() > 25 && genderNeutralAngopet.getAge() < 35) {
                        int1 = rand.nextInt(20) - 10;
                        int2 = rand.nextInt(20) - 10;
                        int op = rand.nextInt(2);
                        if (op == 1) {
                            operation = "*";
                        } else {
                            operation = "/";
                        }
                    }
                    if (genderNeutralAngopet.getAge() > 35 && genderNeutralAngopet.getAge() < 45) {
                        int1 = rand.nextInt(40) - 20;
                        int2 = rand.nextInt(40) - 20;
                        int op = rand.nextInt(2);
                        if (op == 1) {
                            operation = "*";
                        } else {
                            operation = "/";
                        }
                    }
                    playString = int1 + " " + operation + " " + int2 + " =";
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
        for(int i = 0; i < buttons.size(); i++) {
            buttons.get(i).render(canvas);
        }
        
        if (stage.getSet() == "StartingScreen") {
            genderNeutralAngopet.render(canvas);
        }

    }

}
