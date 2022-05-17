package org.headroyce.AngoPets;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import java.util.Random;

/**
 * Represents the most basic version of an AngoPet
 */
public class AngoPet {
    /**
     * the image to be drawn instead of a ball
     */
    private Random rand;
    public Image img;
    private String color, mood;
    private double x, y, width, height;
    private int hunger, xSpeed, ySpeed, age, health, horizontalFlip;
    private boolean isSick;

    public AngoPet(double width, double height) {
        color = "";
        rand = new Random();
        this.setWidth(width);
        this.setHeight(height);
        img = new Image("file:PICS/babyDefault.png");
        this.isSick = false;
        horizontalFlip = 1;
        this.health = 10;
        this.hunger = 10;
        this.xSpeed = 1;
        this.ySpeed = 1;
        this.age = 0;
        this.mood = "Bored";
        this.x = 50;
        this.y = 50;
    }
    public AngoPet() {
        rand = new Random();
        color = "";
        this.xSpeed = 0;
        this.ySpeed = 0;
        img = new Image("file:PICS/babyDefault.png");
        this.isSick = false;
        this.health = 10;
        this.hunger = 0;
        this.mood = "Bored";
        this.age = 0;
        this.x = 50;
        this.y = 50;
        this.setWidth(50);
        this.setHeight(50);
    }


    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double getWidth() {
        return this.width;
    }
    public double getHeight() {
        return this.height;
    }
    public int getAge() { return this.age; }
    public int getHealth() { return this.health; }

    public void setX(double x) {
      this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setAge(int age) { this.age = age; }
    public void setXSpeed(int speed) { this.xSpeed = speed; }
    public void setYSpeed(int speed) { this.ySpeed = speed; }
    public void setWidth( double width) {
       this.width = width;
    }
    public void setHeight( double height) {
        this.height = height;
    }
    public void setHunger( int hunger) {
        this.hunger = hunger;
    }
    public void setMood( String mood) {
        this.mood = mood;
    }
    public void setIsSick(boolean isSick) {
        this.isSick = isSick;
    }
    public void setHealth(int health) {this.health = health;}
    public int getHunger() {
        return this.hunger;
    }
    public String getMood() {
        return this.mood;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
    public boolean getIsSick() {
        return this.isSick;
    }

    public void age(int age) {
        if (age >= 0 && age <= 5) {
            img = new Image("file:PICS/babyDefault.png");
        }
    }
    public void changeColor() {
        int color = rand.nextInt(5);
        if (color == 0) {
            this.color = "green_";;
        }
        if (color == 1) {
            this.color = "yellow_";
        }
        if (color == 2) {
            this.color = "blue_";;
        }
        if (color == 3) {
            this.color = "red_";;
        }
        if (color == 4) {
            this.color = "purple_";;
        }
    }
    public void randMood() {
        int m = rand.nextInt(4);
        if (m == 0) {
            this.mood = "Bored";
        }
        if (m == 1) {
            this.mood = "Angry";
        }
        if (m == 2) {
            this.mood = "Sad";
        }
        if (m == 3) {
            this.mood = "Happy";
        }
    }
    public void flipHorizontal() {
        this.setWidth(this.horizontalFlip * -1);
    }

    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(new ImagePattern(img));
        if (this.horizontalFlip < 0) {
            gc.fillRect(this.getX() + Math.abs(this.getWidth()), canvas.getHeight() / 2 - this.getHeight() / 2, this.getWidth(), this.getHeight());
        }
        if (this.getWidth() > 0) {
            gc.fillRect(this.getX(), canvas.getHeight() / 2 - this.getHeight() / 2, this.getWidth(), this.getHeight());
        }
        gc.setFill(Color.BLACK);
        gc.fillText("Age: " + this.getAge(), canvas.getWidth()/2, 10);
        gc.fillText("Mood: " + this.getMood(), canvas.getWidth()/2, 30  );
    }
}
