package org.headroyce.AngoPets;

import javafx.scene.image.Image;

/**
 * Represents a specific type of AngoPet
 */
public class Snake extends AngoPet {

    public Snake() {
        img = new Image("file:PICS/babyDefault.png");
        this.setIsSick(false);
        this.setHunger(0);
        this.setHappiness(0);
        this.setX(50);
        this.setY(50);
    }

    public Snake(double width, double height) {
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
        if (age >= 0 && age <= 5) {
            img = new Image("file:PICS/babyDefault.png");
        }
        if (age > 5 && age <= 15) {
            img = new Image("file:PICS/babySnake.png");
        }
        if (age > 15 && age <= 25) {
            img = new Image("file:PICS/green_teenSnake.png");
        }
    }
}
