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
    private Random rand;
    public Image img;
    private String color, mood;
    private double x, y, width, height;
    private int hunger, age, health;
    private boolean isSick;

    /**
     * Creates an AngoPet
     */
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

    /**
     * Gets the X coordinate of the AngoPet
     * @return the current X coordinate
     */
    public double getX() {
        return this.x;
    }
    /**
     * Gets the Y coordinate of the AngoPet
     * @return the current Y coordinate
     */
    public double getY() {
        return this.y;
    }
    /**
     * Gets the width of the AngoPet
     * @return the current width
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * Gets the height of the AngoPet
     * @return the current height
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * Gets the age of the AngoPet
     * @return the current age
     */
    public int getAge() { return this.age; }
    /**
     * Gets the number of health points the AngoPet has
     * @return the number of health points
     */
    public int getHealth() { return this.health; }
    /**
     * Gets the number of hunger points the AngoPet has
     * @return the number of hunger points
     */
    public int getHunger() {
        return this.hunger;
    }
    /**
     * Gets the mood of the AngoPet
     * @return the current moood
     */
    public String getMood() {
        return this.mood;
    }
    /**
     * Gets the color of the AngoPet
     * @return the current color
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Sets the X coordinate of the AngoPet
     * @param x the new X coodinate to set to
     */
    public void setX(double x) {
      this.x = x;
    }
    /**
     * Sets the Y coordinate of the AngoPet
     * @param y the new Y coodinate to set to
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * Sets the width of the AngoPet
     * @param width the new width to set to
     */
    public void setWidth( double width) {
       this.width = width;
    }
    /**
     * Sets the height of the AngoPet
     * @param height the new height to set to
     */
    public void setHeight( double height) {
        this.height = height;
    }
    /**
     * Sets the age of the AngoPet
     * @param age the new age to set to
     */
    public void setAge(int age) { this.age = age; }
    /**
     * Sets the number of health points the AngoPet has
     * @param health the new number of health points to set to
     */
    public void setHealth(int health) {this.health = health;}
    /**
     * Sets the number of hunger points the AngoPet has
     * @param hunger the new number of hunger points to set to
     */
    public void setHunger( int hunger) {
        if (hunger > 20) {
            this.hunger = 20;
        } else {
            this.hunger = hunger;
        }
    }
    /**
     * Sets the mood of the AngoPets
     * @param mood the new mood to set to
     */
    public void setMood( String mood) {
        this.mood = mood;
    }
    /**
     * Sets the color of the AngoPet
     * @param color the new color to set to
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Sets the image and age of the AngoPet depending on the age
     * @param age the age to set to
     */
    public void age(int age) {
        if (age >= 0 && age <= 5) {
            img = new Image("file:PICS/babyDefault.png");
        }
        this.age = age;
    }

    /**
     * Randomly chooses the color of the AngoPet
     */
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

    /**
     * Changes the mood of the AngoPet down the mood order
     */
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

    /**
     * Changes the mood of the AngoPet up the mood order
     */
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

    /**
     * Renders this object onto the canvas
     * @param canvas the canvas to render onto
     */
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
