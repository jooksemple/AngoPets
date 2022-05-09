package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

/**
 * Represents the clickable objects in the game
 */
public class Button {
    private double x, y, width, height, xSpeed, ySpeed;
    private String text;
    private Color color;
    private boolean isOn;
    private boolean isShowing;

    /**
     * Creates a standard button
     */
    public Button() {
        isOn = false;
        isShowing = true;
        this.x = 0;
        this.y = 0;
        this.width = 40;
        this.height = 40;
        this.text = "text";
    }

    /**
     * Creates a button with custom coordinates and dimensions
     * @param x the x coordinate of the button
     * @param y the y coordinate of the button
     * @param width the width of the button
     * @param height the height of the button
     */
    public Button(double x, double y, double width, double height) {
        isOn = false;
        isShowing = true;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the status of isOn (Whether the button has been clicked)
     * @return the current status of isOn
     */
    public boolean isOn() { return this.isOn; }

    /**
     * Gets the X coordinate of the Button
     * @return the X coordinate
     */
    public double getX() {
        return this.x;
    }
    /**
     * Gets the Y coordinate of the Button
     * @return the Y coordinate
     */
    public double getY() {
        return this.y;
    }
    /**
     * Gets the width of the button
     * @return the width of the button
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * Gets the height of the button
     * @return the height of the button
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * Gets the color of the button
     * @return the color of the button
     */
    public Color getColor() {return this.color; }
    /**
     * Gets the text set to the button
     * @return the text of the button
     */
    public String getText() {return this.text; }
    /**
     * Sets the speed of the button in the X direction
     * @param xSpeed the new X speed
     */
    public void setXSpeed(double xSpeed) {this.xSpeed = xSpeed; }

    /**
     * Sets the speed of the button in the Y direction
     * @param ySpeed the new Y speed
     */
    public void setYSpeed(double ySpeed) {this.ySpeed = ySpeed; }


    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public double getXSpeed() {return this.xSpeed; }
    public double getYSpeed() {return this.ySpeed; }
    public void setText( String text) {
        this.text = text;
    }
    public void setWidth( double width) {
        this.width = width;
    }
    public void setHeight( double height) {
        this.height = height;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setColor(Color color) {this.color = color; }

    public void click() {
        if (isShowing) {
            isOn = !isOn;
        }
    }
    public String getStage() {
        return "StartingScreen";
    }
    public boolean getIsShowing() {
        return this.isShowing;
    }

    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if (isShowing) {
            gc.setFill(this.color);
            gc.fillRect(this.x, this.y, this.width, this.height);
            gc.setFill(this.color.invert());
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            gc.fillText(this.text, this.x + this.width / 2, this.y + this.height / 2);
        }
    }
}
