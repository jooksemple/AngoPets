package org.headroyce.AngoPets;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

/**
 * Represents the most basic version of an AngoPet
 */
public class AngoPet {
    /**
     * the image to be drawn instead of a ball
     */
    public Image img;
    private double x, y, width, height;
    private int hunger, happiness, xSpeed, ySpeed, age;
    private boolean isSick;

    public AngoPet(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        img = new Image("file:PICS/baby.jpg");
        this.isSick = false;
        this.hunger = 0;
        this.xSpeed = 1;
        this.ySpeed = 1;
        this.age = 0;
        this.happiness = 0;
        this.x = 50;
        this.y = 50;
    }
    public AngoPet() {
        this.xSpeed = 0;
        this.ySpeed = 0;
        img = new Image("file:PICS/baby.jpg");
        this.isSick = false;
        this.hunger = 0;
        this.happiness = 0;
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
    public void setHappiness( int happiness) {
        this.happiness = happiness;
    }
    public void setIsSick(boolean isSick) {
        this.isSick = isSick;
    }
    public int getHunger() {
        return this.hunger;
    }
    public int getHappiness() {
        return this.happiness;
    }

    public boolean getIsSick() {
        return this.isSick;
    }

    public void move() {
        this.x += this.xSpeed;
        this.y += this.ySpeed;
    }

    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        this.setX(canvas.getWidth()/2 - this.getWidth()/2);
        this.setY(canvas.getHeight()/2 - this.getHeight()/2);
        gc.setFill(new ImagePattern(img));
        gc.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}
