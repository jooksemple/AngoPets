package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.Random;

public class Stage {
    private String set, playString;
    private ArrayList<Button> buttons;
    private Random rand;

    public Stage() {
        buttons = new ArrayList<>();
        this.set = "StartingScreen";
        rand = new Random();
    }
    public void setSet(String set) {
        this.set = set;
    }

    public String getSet() {
        return this.set;
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }
    public void setPlayString(String playString) {
        this.playString = playString;
    }
    public void render(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();


        //what the play screen will look like
        if (set == "Play") {
            if (buttons.size() < 10) {
                buttons.clear();
                for (int i = 0; i < 10; i++) {
                    NumberButton e = new NumberButton();
                    e.setX(rand.nextInt((int) canvasWidth));
                    e.setY(-e.getHeight());
                    e.setColor(Color.RED);
                    e.setYSpeed(rand.nextInt(5));
                    e.setXSpeed(rand.nextInt(5) * 2 - 5);
                    buttons.add(e);
                }

            }
            gc.setFill(Color.GREEN);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setFill(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            gc.fillText(playString, canvas.getWidth()/2, canvas.getHeight()/2);
        }
        //what the starting screen will look like
        if (set == "StartingScreen") {
            buttons.clear();

            PlayButton e = new PlayButton(400, 50, 50, 20);
            e.setColor(Color.RED);
            e.setText("PLAY");
            buttons.add(e);

            MenuButton a = new MenuButton(100, 50, 50, 20);
            a.setColor(Color.RED);
            a.setText("MENU");
            buttons.add(a);

            gc.setFill(Color.ALICEBLUE);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
        //What the menu screen will look like
        if (set == "Menu") {
            buttons.clear();
            gc.setFill(Color.RED);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }

    }
}
