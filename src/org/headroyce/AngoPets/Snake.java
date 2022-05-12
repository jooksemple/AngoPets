package org.headroyce.AngoPets;

import javafx.scene.image.Image;

import java.util.Random;

/**
 * Represents a specific type of AngoPet
 */
public class Snake extends AngoPet {
    private Random rand;

    public Snake() {
        this.setColor("_green");
        rand = new Random();
        img = new Image("file:PICS/babyDefault.png");
        this.setIsSick(false);
        this.setHunger(0);
        this.setHappiness(0);
        this.setX(50);
        this.setY(50);
    }

    public Snake(double width, double height) {
        this.setColor("_green");
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

        if (age >= 0 && age <= 5) {
            img = new Image("file:PICS/babyDefault.png");
        }
        if (age > 5 && age <= 15) {
            if (age == 6) {
                this.changeColor();
            }
            img = new Image("file:PICS/" + this.getColor() +"babySnake.png");
        }
        if (age > 15 && age <= 25) {
            img = new Image("file:PICS/" + this.getColor() +"teenSnake.png");
        }
        if (age > 25 && age <= 35) {
            if (age == 26) {
                this.setWidth(this.getWidth() * 1.5);
                this.setHeight(this.getHeight() * 1.5);
            }

            img = new Image("file:PICS/" + this.getColor() +"teenDragon.png");
        }
        if (age > 35 && age <= 45) {
            if (age == 36) {
                this.setWidth(this.getWidth() * 1.5);
                this.setHeight(this.getHeight() * 1.5);
            }
            img = new Image("file:PICS/" + this.getColor() +"dragon.png");
        }
    }
}
