package org.headroyce.AngoPets;

import javafx.animation.AnimationTimer;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the logic of the game
 */
public class GameLogic {
    private static final int HUNGER_TIMER = 3500;
    private static final int AGE_TIMER = 5000;
    private static final int WALK_TIMER = 1000;
    private static final int MOOD_TIMER = 35000;
    private static final int GAME_STEP_TIMER = 100;
    private Bar hunger, health;
    private ArrayList<Projectile> bullet, asteroids;
    private Random rand;
    private ArrayList<Button> buttons;
    private ArrayList<NumberButton> numButtons;
    private GameTimer gameTimer;
    private double canvasWidth, canvasHeight;
    private double double1, double2, mouseX, mouseY;
    private String operation, playString, upgradeText;
    private AngoPet genderNeutralAngopet;
    private Stage stage;
    private int walkingDistance = 20;
    private double equals;
    private boolean gameOver, upgradeTextShowing;
    private Spaceship ship;

    public GameLogic() {
        gameOver = false;
        stage = new Stage();
        hunger = new Bar();
        hunger.setText("Hunger");
        hunger.setColor(Color.BROWN);

        health = new Bar();
        health.setText("Health");
        health.setColor(Color.DARKRED);

        ship = new Spaceship();
        bullet = new ArrayList<>();
        asteroids = new ArrayList<>();
        buttons = new ArrayList<>();
        numButtons = new ArrayList<>();
        rand = new Random();
        gameTimer = new GameTimer();
        if (rand.nextInt(2) == 1) {
            genderNeutralAngopet = new Snake(175, 140);
        } else {
            genderNeutralAngopet = new Cat(175, 140);
        }
        genderNeutralAngopet.setHunger(20);
        double1 = rand.nextInt(10);
        double2 = rand.nextInt(10);
        operation = "+";
        playString = "";
        gameTimer.start();
    }

    /**
     * Checks for when a button is clicked
     *
     * @param mouseEvent the cursor clicking the button
     */
    public void click(MouseEvent mouseEvent) {
        mouseX = (mouseEvent.getX());
        mouseY = (mouseEvent.getY());
        if (mouseEvent.getX() >= genderNeutralAngopet.getX() && mouseEvent.getX() <= genderNeutralAngopet.getX() + genderNeutralAngopet.getWidth() && mouseEvent.getY() >= genderNeutralAngopet.getY() && mouseEvent.getY() <= genderNeutralAngopet.getY() + genderNeutralAngopet.getHeight()) {

        }

        for (int i = 0; i < buttons.size(); i++) {
            if (isWithin(mouseEvent.getX(), mouseEvent.getY(), buttons.get(i))) {
                buttons.get(i).click();
            }
        }
        for (int i = 0; i < numButtons.size(); i++) {
            if (isWithin(mouseEvent.getX(), mouseEvent.getY(), numButtons.get(i))) {
                numButtons.get(i).click();
            }
        }

    }

    public void keyPress(KeyEvent event) {
        if (stage.getSet().equals("PlayTwo")) {
            if (event.getCode() == KeyCode.RIGHT) {
                ship.setXSpeed(6);
            }
            if (event.getCode() == KeyCode.LEFT) {
                ship.setXSpeed(-6);
            }
            if (event.getCode() == KeyCode.SPACE) {
                Projectile e = new Projectile();
                e.setShowing(true);
                e.setX(ship.getX() + ship.getWidth() / 2 - e.getWidth() / 2);
                e.setY(ship.getY() - e.getHeight());
                e.setXSpeed(0);
                e.setYSpeed(-12);
                bullet.add(e);
            }
        }
    }

    public void keyRelease(KeyEvent event) {
        if (stage.getSet().equals("PlayTwo")) {
            if (event.getCode() == KeyCode.RIGHT) {
                if (ship.getXSpeed() == 6) {
                    ship.setXSpeed(0);
                }
            }
            if (event.getCode() == KeyCode.LEFT) {
                if (ship.getXSpeed() == -6) {
                    ship.setXSpeed(0);
                }
            }
        }
    }

    /**
     * Method to check whether a Spaceship is touching another Spaceship. Returns true if they touch, false otherwise
     *
     * @param a the first Projectile
     * @param b the second Projectile
     * @return returns true if they touch, false otherwise.
     */
    public boolean isTouching(Spaceship a, Spaceship b) {
        if (a.getY() + a.getHeight() < b.getY() || a.getY() > b.getY() + b.getHeight() || a.getX() + a.getWidth() < b.getX() || a.getX() > b.getX() + b.getWidth()) {
            return false;
        }
        return true;
    }

    /**
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

        private long walkUpdate, ageUpdate, hungerUpdate, lastUpdate, moodUpdate, upgradeTextUpdate;

        public GameTimer() {
            ageUpdate = lastUpdate = walkUpdate = hungerUpdate = moodUpdate = upgradeTextUpdate = 0;
        }

        @Override
        public void handle(long now) {
            if (gameOver == false) {
                if (upgradeTextShowing) {
                    upgradeTextUpdate = now;
                    upgradeTextShowing = false;
                }
                long text_time_elapsed = (now - upgradeTextUpdate) / 1000000;

                long mood_time_elapsed = (now - moodUpdate) / 1000000;
                long age_time_elapsed = (now - ageUpdate) / 1000000;
                long walk_time_elapsed = (now - walkUpdate) / 1000000;
                long time_elapsed = (now - lastUpdate) / 1000000;
                long hunger_time_elapsed = (now - hungerUpdate) / 1000000;

                if (age_time_elapsed > AGE_TIMER) {
                    if (genderNeutralAngopet.getHunger() > 10) {
                        genderNeutralAngopet.age(genderNeutralAngopet.getAge() + 1);
                    }
                    ageUpdate = now;
                }
                if (text_time_elapsed > 1000) {
                    upgradeText = "";
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
                if (mood_time_elapsed > MOOD_TIMER) {
                    genderNeutralAngopet.changeMood();
                    moodUpdate = now;
                }


                if (time_elapsed > GAME_STEP_TIMER) {
                    lastUpdate = now;
                }
                lastUpdate = now;


                if (genderNeutralAngopet.getHealth() <= 0 || genderNeutralAngopet.getAge() > 99) {
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
                    ship.setXSpeed(0);
                    playString = "";
                    asteroids.clear();
                    bullet.clear();
                    ship.setShowing(false);
                    hunger.setShowing(true);
                    hunger.setWidth(genderNeutralAngopet.getHunger() * 10);
                    hunger.setX(canvasWidth / 2 - hunger.getWidth() / 2);
                    hunger.setY(50);

                    health.setShowing(true);
                    health.setWidth(genderNeutralAngopet.getHealth() * 20);
                    health.setX(canvasWidth / 2 - health.getWidth() / 2);
                    health.setY(80);

                    buttons.clear();

                    Button e = new Button((canvasWidth / 8 * 7) - 25, 10, 100, 20);
                    e.setColor(Color.DARKBLUE);
                    e.setText("Play Hunger");
                    e.setStage("PlayOne");
                    buttons.add(e);

                    Button a = new Button((canvasWidth / 8 * 7) - 25, 40, 100, 20);
                    a.setColor(Color.DARKBLUE);
                    a.setText("Play Mood");
                    a.setStage("PlayTwo");
                    buttons.add(a);

                    MenuButton d = new MenuButton((canvasWidth / 8) - 25, 10, 50, 20);
                    d.setColor(Color.DARKBLUE);
                    d.setText("Menu");
                    buttons.add(d);
                }

                if (stage.getSet().equals("PlayOne")) {
                    ship.setXSpeed(0);
                    asteroids.clear();
                    bullet.clear();
                    ship.setShowing(false);
                    hunger.setShowing(false);
                    health.setShowing(false);

                    buttons.clear();
                    if (numButtons.size() != 10) {
                        for (int i = numButtons.size(); i < 10; i++) {
                            NumberButton e = new NumberButton();
                            e.setX(rand.nextInt((int) canvasWidth));
                            e.setY(-e.getHeight());
                            e.setColor(Color.DARKBLUE);
                            e.setWidth(50);
                            e.setHeight(20);
                            e.setYSpeed(rand.nextDouble(2) + 0.5);
                            e.setXSpeed(rand.nextDouble(2) * 2 - 2);
                            e.setNumber(rand.nextInt(50) - 25);

                            numButtons.add(e);
                        }
                    }

                    Button c = new Button(((canvasWidth / 8) * 7), 10, 50, 20);
                    c.setText("Back");
                    c.setColor(Color.RED);
                    c.setStage("StartingScreen");
                    buttons.add(c);
                    for (int i = 0; i < numButtons.size(); i++) {
                        if (numButtons.get(i).isOn()) {
                            if (numButtons.get(i).getNumber() == equals) {
                                upgradeTextShowing = true;

                                    if (genderNeutralAngopet.getMood().equals("Bored")) {
                                        upgradeText = "+3 Hunger!";
                                        genderNeutralAngopet.setHunger(genderNeutralAngopet.getHunger() + 3);
                                    } else if (genderNeutralAngopet.getMood().equals("Angry")) {
                                        upgradeText = "+2 Hunger!";
                                        genderNeutralAngopet.setHunger(genderNeutralAngopet.getHunger() + 2);
                                    } else if (genderNeutralAngopet.getMood().equals("Happy")) {
                                        upgradeText = "+4 Hunger!";
                                        genderNeutralAngopet.setHunger(genderNeutralAngopet.getHunger() + 4);
                                    } else if (genderNeutralAngopet.getMood().equals("Sad")) {
                                        upgradeText = "+0 Hunger! Your Angopet is Sad!";
                                    }

                                numButtons.remove(i);
                                playString = "";
                            }

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
                    if (genderNeutralAngopet.getAge() > 5 && genderNeutralAngopet.getAge() < 25) {
                        double1 = rand.nextInt(20);
                        double2 = rand.nextInt(20);
                        operation = "-";
                        equals = double1 - double2;
                    }
                    if (genderNeutralAngopet.getAge() > 25 && genderNeutralAngopet.getAge() < 45) {
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
                    if (genderNeutralAngopet.getAge() > 45 && genderNeutralAngopet.getAge() < 65) {
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
                    if (genderNeutralAngopet.getAge() > 65 ) {
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
                    if (double1 == 0 && double2 == 0) {
                        double1 = 3;
                    }
                    String answer = "" + equals;
                    if (answer.length() > 4 && operation == "/") {
                        while (answer.length() > 4) {
                            if (genderNeutralAngopet.getAge() > 25 && genderNeutralAngopet.getAge() < 45) {
                                double1 = rand.nextInt(10);
                                double2 = rand.nextInt(10);
                                equals = double1 / double2;
                            }
                            if (genderNeutralAngopet.getAge() > 45 && genderNeutralAngopet.getAge() < 65) {
                                double1 = rand.nextInt(20) - 10;
                                double2 = rand.nextInt(20) - 10;
                                equals = double1 / double2;
                            }
                            if (genderNeutralAngopet.getAge() > 65) {
                                double1 = rand.nextInt(20) - 10;
                                double2 = rand.nextInt(20) - 10;
                                equals = double1 / double2;
                            }
                            answer = "" + equals;
                        }
                    }
                    playString = (int) double1 + " " + operation + " " + (int) double2 + " =";
                    stage.setPlayString(playString);
                }


                if (stage.getSet() == "Menu") {
                    ship.setXSpeed(0);
                    playString = "";
                    asteroids.clear();
                    bullet.clear();
                    hunger.setShowing(false);
                    health.setShowing(false);
                    buttons.clear();
                    Button x = new Button((canvasWidth / 4 * 3) - 25, 10, 50, 20);
                    x.setText("Back");
                    x.setColor(Color.RED);
                    x.setStage("StartingScreen");
                    buttons.add(x);
                }
                if (stage.getSet().equals("PlayTwo")) {
                    ship.setShowing(true);
                    ship.setWidth(80);
                    ship.setHeight(100);
                    if (ship.getX() + ship.getWidth() > canvasWidth) {
                        ship.setX(canvasWidth - ship.getWidth());
                    }
                    if (ship.getX() < 0) {
                        ship.setX(0);
                    }
                    if (asteroids.size() < 5) {
                        for (int i = asteroids.size(); i < 5; i++) {
                            Asteroid e = new Asteroid();
                            e.setShowing(true);
                            e.setX(rand.nextInt((int) canvasWidth));
                            e.setY(-e.getHeight());
                            e.setXSpeed(0);
                            e.setYSpeed(1);
                            e.setNumber(rand.nextInt(50) - 25);
                            asteroids.add(e);
                        }
                    }
                    for (int i = 0; i < asteroids.size(); i++) {
                        for (int j = 0; j < bullet.size(); j++) {
                            if (isTouching(bullet.get(j), asteroids.get(i))) {
                                if (asteroids.get(i).getNumber() == equals) {
                                    stage.setSet("StartingScreen");
                                } else {
                                    asteroids.remove(i);
                                    if (asteroids.size() > 0) {
                                        i--;
                                    }
                                }

                            }
                        }

                    }

                    for (int i = 0; i < asteroids.size() - 1; i++) {
                        if (isTouching(asteroids.get(i), asteroids.get(i + 1))) {

                            asteroids.get(i).setX(asteroids.get(i + 1).getX() - asteroids.get(i + 1).getWidth() - 1);
                            if (asteroids.size() > 0) {
                                i--;
                            }
                        }
                    }

                    if (ship.getX() == 0 && ship.getY() == 0) {
                        ship.setX(canvasWidth / 2);
                        ship.setY((canvasHeight / 4) * 3);
                    }
                    hunger.setShowing(false);
                    health.setShowing(false);
                    buttons.clear();
                    for (int i = 0; i < bullet.size(); i++) {
                        if (bullet.get(i).getY() + bullet.get(i).getHeight() < 0) {
                            bullet.remove(i);
                        }
                    }

                    for (int i = 0; i < asteroids.size(); i++) {
                        if (asteroids.get(i).getX() + asteroids.get(i).getWidth() > canvasWidth || asteroids.get(i).getX() < 0) {
                            asteroids.remove(i);
                            if (asteroids.size() > 0) {
                                i--;
                            }
                        }
                    }

                    for (int i = 0; i < asteroids.size(); i++) {
                        if (asteroids.get(i).getY() + asteroids.get(i).getHeight() > canvasHeight || isTouching(asteroids.get(i), ship)) {
                            if (asteroids.get(i).getNumber() != equals) {
                                stage.setSet("StartingScreen");
                            } else {
                                asteroids.remove(i);
                                genderNeutralAngopet.setMood("Happy");
                                playString = "";
                            }
                        }

                    }


                    Button x = new Button(((canvasWidth / 8) * 7) - 25, 10, 50, 20);
                    x.setText("Back");
                    x.setColor(Color.RED);
                    x.setStage("StartingScreen");
                    buttons.add(x);

                    if (playString.isEmpty()) {

                        if (genderNeutralAngopet.getAge() < 5) {
                            double1 = rand.nextInt(10);
                            double2 = rand.nextInt(10);
                            operation = "+";
                            equals = double1 + double2;
                        }
                        if (genderNeutralAngopet.getAge() > 5 && genderNeutralAngopet.getAge() < 25) {
                            double1 = rand.nextInt(20);
                            double2 = rand.nextInt(20);
                            operation = "-";
                            equals = double1 - double2;
                        }
                        if (genderNeutralAngopet.getAge() > 25 && genderNeutralAngopet.getAge() < 45) {
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
                        if (genderNeutralAngopet.getAge() > 45 && genderNeutralAngopet.getAge() < 65) {
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
                        if (genderNeutralAngopet.getAge() > 65) {
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
                        if (double1 == 0 && double2 == 0) {
                            double1 = 3;
                        }
                        String answer = "" + equals;
                        if (answer.length() > 4 && operation == "/") {
                            while (answer.length() > 4) {
                                if (genderNeutralAngopet.getAge() > 25 && genderNeutralAngopet.getAge() < 45) {
                                    double1 = rand.nextInt(10);
                                    double2 = rand.nextInt(10);
                                    equals = double1 / double2;
                                }
                                if (genderNeutralAngopet.getAge() > 45 && genderNeutralAngopet.getAge() < 65) {
                                    double1 = rand.nextInt(20) - 10;
                                    double2 = rand.nextInt(20) - 10;
                                    equals = double1 / double2;
                                }
                                if (genderNeutralAngopet.getAge() > 65) {
                                    double1 = rand.nextInt(20) - 10;
                                    double2 = rand.nextInt(20) - 10;
                                    equals = double1 / double2;
                                }
                                answer = "" + equals;
                            }
                        }
                        playString = (int) double1 + " " + operation + " " + (int) double2 + " =";
                        stage.setPlayString(playString);
                    }
                }

                genderNeutralAngopet.setY(canvasHeight / 2 - genderNeutralAngopet.getHeight() / 2);
            }
        }
    }


        /**
         * Renders the game elements onto a canvas
         *
         * @param canvas the canvas to render onto
         */
        public void render(Canvas canvas) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            canvasWidth = canvas.getWidth();
            canvasHeight = canvas.getHeight();
            if (!gameOver) {

                stage.render(canvas);

                if (stage.getSet().equals("PlayOne")) {
                    int rightAnswers = 0;
                    for (int i = 0; i < numButtons.size(); i++) {
                        if (numButtons.get(i).getNumber() == equals) {
                            rightAnswers++;
                        }
                    }
                    if (rightAnswers == 0 && numButtons.size() > 0) {
                        numButtons.get(rand.nextInt(numButtons.size())).setNumber(equals);
                    }

                    for (int i = 0; i < numButtons.size(); i++) {

                        if (numButtons.get(i).getX() + numButtons.get(i).getWidth() > canvasWidth) {
                            numButtons.get(i).setXSpeed(Math.abs(numButtons.get(i).getXSpeed()) * -1);
                        }
                        if (numButtons.get(i).getX() < 0) {
                            numButtons.get(i).setXSpeed(Math.abs(numButtons.get(i).getXSpeed()));
                        }
                        if (numButtons.get(i).getY() > canvasHeight) {
                            numButtons.remove(i);

                        }
                        numButtons.get(i).render(canvas);

                    }
                    gc.setFill(Color.BLACK);

                }
                gc.fillText(upgradeText, mouseX, mouseY);

                for (int i = 0; i < buttons.size(); i++) {
                    buttons.get(i).render(canvas);
                }
                hunger.render(canvas);
                health.render(canvas);
                ship.render(canvas);
                for (int i = 0; i < bullet.size(); i++) {
                    bullet.get(i).render(canvas);
                }
                for (int i = 0; i < asteroids.size(); i++) {
                    asteroids.get(i).render(canvas);
                }

                if (stage.getSet() == "StartingScreen") {
                    genderNeutralAngopet.render(canvas);
                }

                if (stage.getSet() == "PlayTwo") {
                    int rightAnswers = 0;
                    for (int i = 0; i < asteroids.size(); i++) {
                        if (asteroids.get(i).getNumber() == equals) {
                            rightAnswers++;
                        }
                    }
                    if (rightAnswers == 0 && asteroids.size() > 0) {
                        asteroids.get(rand.nextInt(asteroids.size())).setNumber(equals);
                    }

                    gc.setFill(Color.WHITE);
                    gc.setTextAlign(TextAlignment.CENTER);
                    gc.setTextBaseline(VPos.CENTER);
                    gc.fillText(playString, canvasWidth / 2, 20);
                }
            } else {
                gc.setFill(Color.BLACK);
                gc.setTextAlign(TextAlignment.CENTER);
                gc.setTextBaseline(VPos.CENTER);
                if (genderNeutralAngopet.getAge() == 100) {
                    gc.fillText("YOU WIN: Your AngoPet Reached the Age of 100!", canvasWidth / 2, canvasHeight / 2);
                } else {
                    gc.fillText("YOU LOSE: Your AngoPet Died!", canvasWidth / 2, canvasHeight / 2);
                }
            }
        }
    }



