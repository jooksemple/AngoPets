package org.headroyce.AngoPets;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;

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
    private int hunger, age, health;
    private boolean isSick;

    public AngoPet() {
        rand = new Random();
        color = "";
        img = new Image("file:PICS/babyDefault.png");
        this.isSick = false;
        this.health = 10;
        this.hunger = 0;
        this.setMood("Bored");
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
    public void setWidth( double width) {
       this.width = width;
    }
    public void setHeight( double height) {
        this.height = height;
    }
    public void setHunger( int hunger) {
        if (hunger > 20) {
            this.hunger = 20;
        } else {
            this.hunger = hunger;
        }

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
    public void changeMood() {

        if (this.mood.equals("Happy")) {
            this.mood = "Bored";
            return;
        }
        if (this.mood.equals("Bored")) {
            this.mood = "Angry";
            return;
        }
        if (this.mood.equals("Angry")) {
            this.mood = "Sad";
            return;
        }
        if (this.mood.equals("Sad")) {
            this.mood = "Sad";
            return;
        }
    }
    public void upMood() {

        if (this.mood.equals("Sad")) {
            this.mood = "Angry";
            return;
        }
        if (this.mood.equals("Angry")) {
            this.mood = "Bored";
            return;
        }
        if (this.mood.equals("Bored")) {
            this.mood = "Happy";
            return;
        }
        if (this.mood.equals("Happy")) {
            this.mood = "Happy";
            return;
        }
    }

    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(new ImagePattern(img));
        gc.fillRect(this.getX(), canvas.getHeight() / 2 - this.getHeight() / 2, this.getWidth(), this.getHeight());
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Verdana", 15));
        gc.fillText("Age: " + this.getAge(), canvas.getWidth()/2, 12);
        gc.fillText("Mood: " + this.getMood(), canvas.getWidth()/2, 35  );
    }
}
