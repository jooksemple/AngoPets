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
    private static final int HUNGER_TIMER = 100000;
    private static final int AGE_TIMER = 1000;
    private static final int WALK_TIMER = 1000;
    private static final int GAME_STEP_TIMER = 100;
    private Bar hunger, health;
    private Random rand;
    private ArrayList<Button> buttons;
    private GameTimer gameTimer;
    private double canvasWidth, canvasHeight;
    private double double1, double2;
    private String operation, playString;
    private AngoPet genderNeutralAngopet;
    private Stage stage;
    private int walkingDistance = 20;
    private double equals;
    private boolean gameOver;

    public GameLogic() {
        gameOver = false;
        stage = new Stage();
        hunger = new Bar();
        hunger.setText("Hunger");
        hunger.setColor(Color.BROWN);

        health = new Bar();
        health.setText("Health");
        health.setColor(Color.DARKRED);

        buttons = new ArrayList<>();
        rand = new Random();
        gameTimer = new GameTimer();
        genderNeutralAngopet = new Snake(85, 70);
        genderNeutralAngopet.setHunger(10);
        double1 = rand.nextInt(10);
        double2 = rand.nextInt(10);
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
        private long hungerUpdate;
        private long walkUpdate;
        private long ageUpdate;


        public GameTimer() {
            ageUpdate = lastUpdate = walkUpdate = hungerUpdate = 0;
        }

        @Override
        public void handle(long now) {
            if (gameOver == false) {
                long age_time_elapsed = (now - ageUpdate) / 1000000;
                long walk_time_elapsed = (now - walkUpdate) / 1000000;
                long time_elapsed = (now - lastUpdate) / 1000000;
                long hunger_time_elapsed = (now - hungerUpdate) / 1000000;

                if (age_time_elapsed > AGE_TIMER) {
                    genderNeutralAngopet.setAge(genderNeutralAngopet.getAge() + 1);
                    genderNeutralAngopet.age(genderNeutralAngopet.getAge());
                    ageUpdate = now;
                }

                if (walk_time_elapsed > WALK_TIMER) {
                    genderNeutralAngopet.setX(genderNeutralAngopet.getX() + walkingDistance);
                    walkUpdate = now;
                }
                if (hunger_time_elapsed > HUNGER_TIMER) {
                    if (genderNeutralAngopet.getHunger() > 0) {
                        genderNeutralAngopet.setHunger(genderNeutralAngopet.getHunger() - 1);
                    } else {
                        genderNeutralAngopet.setHealth(genderNeutralAngopet.getHealth() - 1);
                    }
                    hungerUpdate = now;
                }

                if (time_elapsed > GAME_STEP_TIMER) {
                    lastUpdate = now;
                }
                lastUpdate = now;


                if (genderNeutralAngopet.getHealth() <= 0) {
                    gameOver = true;
                }
                for (int i = 0; i < buttons.size(); i++) {
                    if (buttons.get(i).isOn()) {
                        stage.setSet(buttons.get(i).getStage());
                    }
                }
                if (genderNeutralAngopet.getX() + genderNeutralAngopet.getWidth() > canvasWidth) {
                    walkingDistance = -20;
                }
                if (genderNeutralAngopet.getX() < 0) {
                    walkingDistance = 20;
                }

                if (stage.getSet() == "StartingScreen") {
                    hunger.setShowing(true);
                    hunger.setWidth(genderNeutralAngopet.getHunger() * 20);
                    hunger.setX(canvasWidth / 2 - hunger.getWidth() / 2);
                    hunger.setY(30);

                    health.setShowing(true);
                    health.setWidth(genderNeutralAngopet.getHealth() * 20);
                    health.setX(canvasWidth / 2 - health.getWidth() / 2);
                    health.setY(70);

                    buttons.clear();

                    PlayButton e = new PlayButton((canvasWidth / 8 * 7) - 25, 10, 50, 20);
                    e.setColor(Color.RED);
                    e.setText("Play");
                    buttons.add(e);

                    MenuButton a = new MenuButton((canvasWidth / 8) - 25, 10, 50, 20);
                    a.setColor(Color.RED);
                    a.setText("MENU");
                    buttons.add(a);
                }

                if (stage.getSet().equals("PlayOne")) {
                    hunger.setShowing(false);
                    health.setShowing(false);
                    if (buttons.size() != 11) {
                        playString = "";
                        buttons.clear();
                        for (int i = 0; i < 10; i++) {
                            NumberButton e = new NumberButton();
                            e.setX(rand.nextInt((int) canvasWidth));
                            e.setY(-e.getHeight());
                            e.setColor(Color.DARKBLUE);
                            e.setWidth(50);
                            e.setHeight(20);
                            e.setYSpeed(rand.nextDouble(5));
                            e.setXSpeed(rand.nextDouble(5) * 2 - 5);
                            e.setNumber(rand.nextInt(50) - 25);
                            if (i == 5) {
                                e.setNumber(equals);
                            }
                            buttons.add(e);
                        }
                        Button c = new Button((canvasWidth / 4 * 3) - 25, 10, 50, 20);
                        c.setText("Back");
                        c.setColor(Color.RED);
                        buttons.add(c);
                    }
                    for (int i = 0; i < buttons.size(); i++) {
                        if (buttons.get(i).isOn()) {
                            if (buttons.get(i).getNumber() == equals) {
                                genderNeutralAngopet.setHunger(genderNeutralAngopet.getHunger() + 1);
                                buttons.remove(i);
                                NumberButton e = new NumberButton();
                                e.setX(rand.nextInt((int) canvasWidth));
                                e.setY(-e.getHeight());
                                e.setColor(Color.DARKBLUE);
                                e.setWidth(50);
                                e.setHeight(20);
                                e.setYSpeed(rand.nextDouble(5));
                                e.setXSpeed(rand.nextDouble(5) * 2 - 5);
                                e.setNumber(rand.nextInt(50) - 25);
                                if (i == 5) {
                                    e.setNumber(equals);
                                }
                                buttons.add(e);
                            }
                        }
                    }

                    if (playString.isEmpty()) {
                        if (genderNeutralAngopet.getAge() < 5) {
                            double1 = rand.nextInt(10);
                            double2 = rand.nextInt(10);
                            operation = "+";
                            equals = double1 + double2;
                        }
                        if (genderNeutralAngopet.getAge() > 5 && genderNeutralAngopet.getAge() < 15) {
                            double1 = rand.nextInt(20);
                            double2 = rand.nextInt(20);
                            operation = "-";
                            equals = double1 - double2;
                        }
                        if (genderNeutralAngopet.getAge() > 15 && genderNeutralAngopet.getAge() < 25) {
                            double1 = rand.nextInt(10);
                            double2 = rand.nextInt(10);
                            int op = rand.nextInt(2);
                            if (op == 1) {
                                operation = "*";
                                equals = double1 * double2;
                            } else {
                                operation = "/";
                                equals = double1 / double2;
                            }
                        }
                        if (genderNeutralAngopet.getAge() > 25 && genderNeutralAngopet.getAge() < 35) {
                            double1 = rand.nextInt(20) - 10;
                            double2 = rand.nextInt(20) - 10;
                            int op = rand.nextInt(2);
                            if (op == 1) {
                                operation = "*";
                                equals = double1 * double2;
                            } else {
                                operation = "/";
                                equals = double1 / double2;
                            }
                        }
                        if (genderNeutralAngopet.getAge() > 35 && genderNeutralAngopet.getAge() < 45) {
                            double1 = rand.nextInt(40) - 20;
                            double2 = rand.nextInt(40) - 20;
                            int op = rand.nextInt(2);
                            if (op == 1) {
                                operation = "*";
                                equals = double1 * double2;
                            } else {
                                operation = "/";
                                equals = double1 / double2;
                            }
                        }
                        playString = double1 + " " + operation + " " + double2 + " =";
                        stage.setPlayString(playString);
                    }
                }

                genderNeutralAngopet.setY(canvasHeight / 2 - genderNeutralAngopet.getHeight() / 2);
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


        if (stage.getSet().equals("PlayOne")) {

            for (int i = 0; i < buttons.size(); i++) {

                if (buttons.get(i).getX() + buttons.get(i).getWidth() > canvasWidth) {
                    buttons.get(i).setXSpeed(Math.abs(buttons.get(i).getXSpeed()) * -1);
                }
                if (buttons.get(i).getX() < 0) {
                    buttons.get(i).setXSpeed(Math.abs(buttons.get(i).getXSpeed()));
                }
                if (buttons.get(i).getY() + buttons.get(i).getHeight() > canvasHeight) {

                    buttons.remove(i);
                    NumberButton e = new NumberButton();
                    e.setX(rand.nextInt((int) canvasWidth));
                    e.setY(-e.getHeight());
                    e.setColor(Color.DARKBLUE);
                    e.setWidth(50);
                    e.setHeight(20);
                    e.setYSpeed(rand.nextDouble(5));
                    e.setXSpeed(rand.nextDouble(5) * 2 - 5);
                    e.setNumber(rand.nextInt(50) - 25);
                    if (i == 5) {
                        e.setNumber(equals);
                    }
                    buttons.add(e);
                }
            }
        }

        for(int i = 0; i < buttons.size(); i++) {
            buttons.get(i).render(canvas);
        }
        hunger.render(canvas);
        health.render(canvas);
        if (stage.getSet() == "StartingScreen") {
            genderNeutralAngopet.render(canvas);

        }

    }

}
