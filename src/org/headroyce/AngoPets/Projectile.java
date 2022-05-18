package org.headroyce.AngoPets;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
    public double getNumber() {return this.number;}
    public void setNumber(double number) {this.number = number;}

    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if (this.isShowing()) {
            move();
            gc.setFill(Color.RED);
            gc.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }

}
