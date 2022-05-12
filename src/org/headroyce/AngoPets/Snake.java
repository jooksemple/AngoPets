package org.headroyce.AngoPets;

import javafx.scene.image.Image;

import java.util.Random;

/**
 * Represents a specific type of AngoPet
 */
public class Snake extends AngoPet {
    private Random rand;
    private String Color;
    public Snake() {
        Color = "";
        rand = new Random();
        img = new Image("file:PICS/babyDefault.png");
        this.setIsSick(false);
        this.setHunger(0);
        this.setHappiness(0);
        this.setX(50);
        this.setY(50);
    }

    public Snake(double width, double height) {
        Color = "";
        rand = new Random();
        this.setWidth(width);
        this.setHeight(height);
        img = new Image("file:PICS/babyDefault.png");
        this.setIsSick(false);
        this.setHunger(0);
        this.setHappiness(0);
        this.setX(50);
        this.setY(50);
    }

    public void age(int age) {
        int color = rand.nextInt(5);
        if (color == 1) {
            Color = "green_";;
        }
        if (color == 2) {
            Color = "yellow_";
        }
        if (color == 3) {
            Color = "blue_";;
        }
        if (color == 4) {
            Color = "red_";;
        }
        if (color == 5) {
            Color = "purple_";;
        }
        if (age >= 0 && age <= 5) {
            img = new Image("file:PICS/babyDefault.png");
        }
        if (age > 5 && age <= 15) {
            img = new Image("file:PICS/" + Color +"babySnake.png");
        }
        if (age > 15 && age <= 25) {
            img = new Image("file:PICS/" + Color +"teenSnake.png");
        }
    }
}
