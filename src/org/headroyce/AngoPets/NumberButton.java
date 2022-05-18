package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.TextAlignment;

import java.util.Random;

/**
 * Represents the buttons of the Hunger game
 */
public class NumberButton extends Button{
    private Random rand;

    /**
     * Creates a NumberButton
     */
    public NumberButton() {
        this.setXSpeed(0);
        this.setYSpeed(0);
        this.setWidth(50);
        this.setHeight(50);
        rand = new Random();
    }

    /**
     * Gets the current stage
     * @return
     */
    public String getStage() {
        return "PlayOne";
    }

    /**
     * Commands to do when a Number Button is clicked
     */
    public void click() {
        if (this.getIsShowing()) {
            this.setIsOn(true);
        }
    }

    /**
     * Renders the game elements onto a canvas
     * @param canvas the canvas to render onto
     */
    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        String num = "" + this.getNumber();
        if (num.charAt(num.length() - 1) =='0' && num.charAt(num.length() - 2) =='.') {
            num = "" + (int) this.getNumber();
        }
        if (this.getIsShowing()) {
            this.move();
            gc.setFill(this.getColor());
            gc.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
            gc.setFill(this.getColor().invert());
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            gc.fillText(num, this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);
        }
    }

}
