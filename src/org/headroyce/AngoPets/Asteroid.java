package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Represents the Asteroids in the Mood game
 */
public class Asteroid extends Projectile {

    /**
     * Creates an Asteroid
     */
    public Asteroid() {
        this.setShowing(true);
        this.setWidth(40);
        this.setHeight(40);
        this.setX(0);
        this.setY(0);
        this.setImage(new Image("file:PICS/asteroid.png"));
    }

    /**
     * Renders this object onto the canvas
     * @param canvas the canvas to render onto
     */
    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if (this.isShowing()) {
            move();
            String num = "" + this.getNumber();
            if (num.charAt(num.length() - 1) =='0' && num.charAt(num.length() - 2) =='.') {
                num = "" + (int) this.getNumber();
            }

            gc.setFill(new ImagePattern(this.getImage()));
            gc.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
            gc.setFill(Color.BLACK);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            gc.setFont(Font.font ("Verdana", 15));
            gc.fillText("" + num, this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2);
        }
    }
}
