package org.headroyce.AngoPets;

import javafx.scene.image.Image;

import java.util.Random;

public class Cat extends AngoPet {
    private Random rand;
    /**
     * Represents a specific type of AngoPet
     */

        public Cat() {
            rand = new Random();
            this.changeColor();
            img = new Image("file:PICS/babyDefault.png");
            this.setIsSick(false);
            this.setHunger(0);
            this.setMood("Bored");
            this.setX(50);
            this.setY(50);
        }

        public Cat(double width, double height) {
            rand = new Random();
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

