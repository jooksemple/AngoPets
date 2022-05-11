package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.TextAlignment;

import java.util.Random;

/**
 * Represents the buttons of the Asteroid game
 */
public class NumberButton extends Button{
    private int number;
    private Random rand;
    private double x, y;

    public NumberButton(double x, double y, double width, double height) {
        this.setIsOn(false);
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.setXSpeed(0);
        this.setYSpeed(0);
        rand = new Random();
        this.number = rand.nextInt(50);

    }
    public NumberButton() {
        this.x = 0;
        this.y = 0;
        this.setXSpeed(0);
        this.setYSpeed(0);
        this.setWidth(50);
        this.setHeight(50);
        rand = new Random();
        this.number = rand.nextInt(50);
    }

    public String getStage() {
        return "Play";
    }

    public void click() {
        if (this.getIsShowing()) {
            this.setIsOn(!this.isOn());
        }

    }

    public void move() {
        this.x += this.getXSpeed();
        this.y += this.getYSpeed();
    }
    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        if (this.getIsShowing()) {
            this.move();
            gc.setFill(this.getColor());
            gc.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
            gc.setFill(this.getColor().invert());
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            gc.fillText(this.getText(), this.x + this.getWidth() / 2, this.y + this.getHeight() / 2);
        }
    }

}
