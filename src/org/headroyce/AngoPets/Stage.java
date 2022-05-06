package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class Stage {
    private String set;
    private ArrayList<Button> buttons;

    public Stage() {
        buttons = new ArrayList<>();
        this.set = "StartingScreen";
    }
    public void setSet(String set) {
        this.set = set;
    }
    public ArrayList<Button> getButtons() {
        return buttons;
    }

    public void render(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        buttons.clear();

        //what the play screen will look like
        if (set == "Play") {
            gc.setFill(Color.GREEN);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
        //what the starting screen will look like
        if (set == "StartingScreen") {

            PlayButton e = new PlayButton(400, 50, 50, 20);
            e.setColor(Color.RED);
            e.setText("PLAY");
            buttons.add(e);

            gc.setFill(Color.ALICEBLUE);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
        //What the menu screen will look like
        if (set == "Menu") {
            gc.setFill(Color.ALICEBLUE);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }

    }
}
