package org.headroyce.AngoPets;

import javafx.scene.image.Image;

import java.util.Random;

/**
 * Represents a specific type of AngoPet
 */
public class Cat extends AngoPet {
    private Random rand;

    /**
     * Creates a cat AngoPet
     */
    public Cat() {
        rand = new Random();
        this.changeColor();
        img = new Image("file:PICS/babyDefault.png");
        this.setHunger(0);
        this.setMood("Bored");
        this.setX(50);
        this.setY(50);
    }

    /**
     * Creates a cat AngoPet with a custom width and height
     * @param width the custom width to set the AngoPet
     * @param height the custom height to set the AngoPet
     */
    public Cat(double width, double height) {
        rand = new Random();
        this.changeColor();
        this.setWidth(width);
        this.setHeight(height);
        this.setMood("Bored");
        img = new Image("file:PICS/babyDefault.png");
        this.setHunger(0);
        this.setX(50);
        this.setY(50);
    }

    /**
     * Randomly chooses the color of the AngoPet (Different colors than Snake/default AngoPet)
     */
    public void changeColor() {
        int color = rand.nextInt(5);
        if (color == 0) {
            this.setColor("orange_");
        }
        if (color == 1) {
            this.setColor("yellow_");
        }
        if (color == 2) {
            this.setColor("blue_");
        }
        if (color == 3) {
            this.setColor("red_");
        }
        if (color == 4) {
            this.setColor("purple_");
        }
    }

    /**
     * Changes the image of the AngoPet depending on the age
     * @param age the age to set to
     */
    public void age(int age) {
        if (age >= 0 && age <= 5) {
            img = new Image("file:PICS/babyDefault.png");
        }
        if (age > 5 && age <= 25) {
            if (age == 6) {
                this.changeColor();
            }
            img = new Image("file:PICS/" + this.getColor() +"kitten.png");
        }
        if (age > 25 && age <= 45) {
            img = new Image("file:PICS/" + this.getColor() +"teenCat.png");
        }
        if (age > 45 && age <= 65) {
            if (age == 46) {
                this.setWidth(this.getWidth() * 1.5);
                this.setHeight(this.getHeight() * 1.5);
            }

            img = new Image("file:PICS/" + this.getColor() +"teenGriffin.png");
        }
        if (age > 65 && age <= 85) {
            if (age == 66) {
                this.setWidth(this.getWidth() * 1.5);
                this.setHeight(this.getHeight() * 1.5);
            }
            img = new Image("file:PICS/" + this.getColor() +"griffin.png");
        }
        this.setAge(age);
        }
    }

