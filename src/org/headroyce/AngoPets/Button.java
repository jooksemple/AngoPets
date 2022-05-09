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

    public Button(double x, double y, double width, double height) {
        isOn = false;
        isShowing = true;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Button() {
        isOn = false;
        isShowing = true;
        this.x = 0;
        this.y = 0;
        this.width = 40;
        this.height = 40;
        this.text = "text";
    }
    public boolean isOn() { return this.isOn; }
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
    public Color getColor() {return this.color; }
    public String getText() {return this.text; }
    public void setXSpeed(double xSpeed) {this.xSpeed = xSpeed; }
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
