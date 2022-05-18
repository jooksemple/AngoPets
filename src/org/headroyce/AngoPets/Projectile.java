package org.headroyce.AngoPets;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Represents the Projectiles of the Mood game
 */
public class Projectile extends Spaceship {
    private double number;
    public Projectile() {
        this.number = 0;
        this.setShowing(true);
        this.setWidth(10);
        this.setHeight(20);
        this.setX(0);
        this.setY(0);
    }

    /**
     * Gets the private number of the projectile
     * @return the number
     */
    public double getNumber() {return this.number;}

    /**
     * Sets the private number of the projectile
     * @param number the new number to set to
     */
    public void setNumber(double number) {this.number = number;}

    /**
     * Renders these objects onto the canvas
     * @param canvas the canvas to render onto
     */
    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if (this.isShowing()) {
            move();
            gc.setFill(Color.RED);
            gc.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }
}
