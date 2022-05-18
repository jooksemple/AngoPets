package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.TextAlignment;

/**
 * Represents a Spaceship in the Mood game
 */
public class Spaceship {
        private Image img;
        private boolean isShowing;
        private double x, y, width, height, xSpeed, ySpeed;
        private Color color;
        private String text;

    /**
     * Creates a Spaceship
     */
    public Spaceship() {
        img = new Image("file:PICS/Spaceship.png");
        isShowing = true;
        this.width = this.height = 20;
        this.x = this.y = 0;
    }

    /**
     * Gets the X coordinate of the object
     * @return the X coordinate
     */
    public double getX() {return this.x;}
    /**
     * Gets the Y coordinate of the object
     * @return the Y coordinate
     */
    public double getY() {return this.y;}
    /**
     * Gets the width of the object
     * @return the width
     */
    public double getWidth() {return this.width; }
    /**
     * Gets the height of the object
     * @return the height
     */
    public double getHeight() {return this.height; }
    /**
     * Gets the speed in the X direction of the object
     * @return the X speed
     */
    public double getXSpeed() {return this.xSpeed; }
    /**
     * Gets the current image of the object
     * @return
     */
    public Image getImage() { return this.img; }
    /**
     * Gets the text of the object
     * @return the current text
     */
    public String getText() { return this.text;}/**
     * Gets the state of the object, showing or not
     * @return the current state
     */
    public boolean isShowing() {
        return this.isShowing;
    }

    /**
     * Sets the X coordinate of the object
     * @param x the X coordinate to set to
     */
    public void setX(double x) {this.x = x; }
    /**
     * Sets the Y coordinate of the object
     * @param y the Y coordinate to set to
     */
    public void setY(double y) {this.y = y; }
    /**
     * Sets the width of the object
     * @param width the width to set to
     */
    public void setWidth(double width) {this.width = width; }
    /**
     * Sets the height of the object
     * @param height the height to set to
     */
    public void setHeight(double height) {this.height = height; }
    /**
     * Sets the speed of the object in the X direction
     * @param xSpeed the X speed to set to
     */
    public void setXSpeed(double xSpeed) {this.xSpeed = xSpeed; }
    /**
     * Sets the speed of the object in the Y direction
     * @param ySpeed the Y speed to set to
     */
    public void setYSpeed(double ySpeed) {this.ySpeed = ySpeed; }
    /**
     * Sets the image of the object
     * @param img the new image to set to
     */
    public void setImage(Image img) {  this.img = img; }

    /**
     * Sets the object to show or not
     * @param showing whether to show or not
     */
    public void setShowing(boolean showing) {
        this.isShowing = showing;
    }

    /**
     * Moves the object
     */
    public void move() {
        this.x += this.xSpeed;
        this.y += this.ySpeed;
    }

    /**
     * Renders the object onto the canvas
     * @param canvas the canvas to render onto
     */
    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if (isShowing) {
            move();
            gc.setFill(new ImagePattern(img));
            gc.fillRect(this.x, this.y, this.width, this.height);
        }
    }
}

