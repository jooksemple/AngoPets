package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Represents the clickable objects in the game
 */
public class Button {
    private double x, y, width, height, xSpeed, ySpeed;
    private String text, stage;
    private Color color;
    private boolean isOn;
    private double number;
    private boolean isShowing;

    /**
     * Creates a standard button
     */
    public Button() {
        stage = "StartingScreen";
        isOn = false;
        isShowing = true;
        this.x = 0;
        this.y = 0;
        this.width = 40;
        this.height = 40;
        this.number = 0;
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
        stage = "StartingScreen";
        isOn = false;
        isShowing = true;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.number = 0;
    }

    /**
     * Gets the status of isOn (Whether the button has been clicked)
     * @return the current status of isOn
     */
    public boolean isOn() { return this.isOn; }
    /**
     * Sets the status of IsOn (Whether the button has been clicked)
     * @param isOn the new status to set to
     */
    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }
    /**
     * Gets the X coordinate of the Button
     * @return the X coordinate
     */
    public double getX() {
        return this.x;
    }
    /**
     * Sets the X coordinate of the button
     * @param x the new X coordinate
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Gets the Y coordinate of the Button
     * @return the Y coordinate
     */
    public double getY() {
        return this.y;
    }
    /**
     * Sets the Y coordinate of the button
     * @param y the new Y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * Gets the width of the button
     * @return the width of the button
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * Sets the width of the button
     * @param width the new width to set to
     */
    public void setWidth( double width) {
        this.width = width;
    }
    /**
     * Gets the height of the button
     * @return the height of the button
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * Sets the height of the button
     * @param height the new height to set to
     */
    public void setHeight( double height) {
        this.height = height;
    }
    /**
     * Gets the color of the button
     * @return the color of the button
     */
    public Color getColor() {return this.color; }

    /**
     * Sets the color of the button
     * @param color the new color to set to
     */
    public void setColor(Color color) {this.color = color; }
    /**
     * Gets the text set to the button
     * @return the text of the button
     */
    public String getText() {return this.text; }
    /**
     * Sets the text of the button
     * @param text the new text to set to
     */
    public void setText( String text) {
        this.text = text;
    }

    /**
     * Gets the speed of the button in the X direction
     * @return the X speed
     */
    public double getXSpeed() {return this.xSpeed; }
    /**
     * Sets the speed of the button in the X direction
     * @param xSpeed the new X speed
     */
    public void setXSpeed(double xSpeed) {this.xSpeed = xSpeed; }
    /**
     * Sets the speed of the button in the Y direction
     * @return the Y speed
     */
    public double getYSpeed() {return this.ySpeed; }
    /**
     * Sets the speed of the button in the Y direction
     * @param ySpeed the new Y speed
     */
    public void setYSpeed(double ySpeed) {this.ySpeed = ySpeed; }

    public void setNumber(double number) {
        this.number = number;
    }
    /**
     * Changes the status of isOn if the button has been clicked
     */
    public void click() {
        if (isShowing) {
            isOn = !isOn;
        }
    }

    public void move() {
        this.x += this.getXSpeed();
        this.y += this.getYSpeed();
    }

    public double getNumber() {
        return this.number;
    }
    /**
     * Gets the current stage of the canvas
     * @return the
     */
    public String getStage() {
        return stage;
    }

    /**
     * Gets the
     * @return
     */
    public void setStage(String stage) {
        this.stage = stage;
    }
    public boolean getIsShowing() {
        return this.isShowing;
    }

    /**
     * Renders the game elements onto a canvas
     * @param canvas the canvas to render onto
     */
    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if (isShowing) {
            gc.setFill(this.color);
            gc.fillRect(this.x, this.y, this.width, this.height);
            gc.setFill(this.color.invert());
            gc.setFont(Font.font ("Arial", 15));
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);

            gc.fillText(this.text, this.x + this.width / 2, this.y + this.height / 2);
        }
    }
}
