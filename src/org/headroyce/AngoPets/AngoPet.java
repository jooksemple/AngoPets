package org.headroyce.AngoPets;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class AngoPet {
    /**
     * the image to be drawn instead of a ball
     */
    public Image img;
    private double x, y, width, height;
    private int hunger, happiness;
    private boolean isSick;

    public AngoPet(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        img = new Image("file:PICS/baby.jpg");
        this.isSick = false;
        this.hunger = 0;
        this.happiness = 0;
        this.x = 50;
        this.y = 50;
    }
    public AngoPet() {
        img = new Image("file:PICS/baby.jpg");
        this.isSick = false;
        this.hunger = 0;
        this.happiness = 0;
        this.x = 50;
        this.y = 50;
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
    public void setX(double x) {
      this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

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

        gc.setFill(new ImagePattern(img));
        gc.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
}
