package org.headroyce.AngoPets;

import javafx.scene.image.Image;

import java.util.Random;

/**
 * Represents a specific type of AngoPet
 */
public class Snake extends AngoPet {

    public Snake() {
        this.changeColor();
        img = new Image("file:PICS/babyDefault.png");
        this.setIsSick(false);
        this.setHunger(0);
        this.setMood("Bored");
        this.setX(50);
        this.setY(50);
    }

    public Snake(double width, double height) {
        this.changeColor();
        this.setWidth(width);
        this.setHeight(height);
        this.setMood("Bored");
        img = new Image("file:PICS/babyDefault.png");
        this.setIsSick(false);
        this.setHunger(0);
        this.setX(50);
        this.setY(50);
    }


    public void age(int age) {

        if (age >= 0 && age <= 5) {
            img = new Image("file:PICS/babyDefault.png");
        }
        if (age > 5 && age <= 25) {
            if (age == 6) {
                this.changeColor();
            }
            img = new Image("file:PICS/" + this.getColor() +"babySnake.png");
        }
        if (age > 25 && age <= 45) {
            img = new Image("file:PICS/" + this.getColor() +"teenSnake.png");
        }
        if (age > 45 && age <= 65) {
            if (age == 46) {
                this.setWidth(this.getWidth() * 1.5);
                this.setHeight(this.getHeight() * 1.5);
            }

            img = new Image("file:PICS/" + this.getColor() +"teenDragon.png");
        }
        if (age > 65 && age <= 85) {
            if (age == 66) {
                this.setWidth(this.getWidth() * 1.5);
                this.setHeight(this.getHeight() * 1.5);
            }
            img = new Image("file:PICS/" + this.getColor() +"dragon.png");
        }
        this.setAge(age);
    }
}
