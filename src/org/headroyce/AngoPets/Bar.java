package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

/**
 * Represents the Health and Hunger bars
 */
public class Bar {
    private boolean isShowing;
    private double x, y, width, height;
    private Color color;
    private String text;

    /**
     * Creates a bar
     */
    public Bar() {
        isShowing = true;
        this.width = this.height = 30;
        this.x = this.y = 20;
    }

    /**
     * Gets the width of the bar
     * @return the current width of the bar
     */
    public double getWidth() {return this.width; }
    /**
     * Gets the height of the bar
     * @return the current height of the bar
     */
    public double getHeight() {return this.height; }
    /**
     * Gets the text of the bar
     * @return the current text of the bar
     */
    public String getText() { return this.text;}
    /**
     * Gets the state of the bar - showing or not
     * @return the current state
     */
    public boolean isShowing() {
        return this.isShowing;
    }

    /**
     * Sets the width of the bar
     * @param width the new width to set to
     */
    public void setWidth(double width) {this.width = width; }
    /**
     * Sets the height of the bar
     * @param height the new height to set to
     */
    public void setHeight(double height) {this.height = height; }

    /**
     * Sets the text of the bar
     * @param text the text to set to
     */
    public void setText(String text) {this.text = text; }

    /**
     * Sets the X coordinate of the bar
     * @param x the X coordinate to set to
     */
    public void setX(double x) {this.x = x; }
    /**
     * Sets the Y coordinate of the bar
     * @param y the Y coordinate to set to
     */
    public void setY(double y) {this.y = y; }
    /**
     * Sets the color of the bar
     * @param color the color to set to
     */
    public void setColor(Color color) {this.color = color; }

    /**
     * Sets the state of the bar to showing or not
     * @param showing the new state
     */
    public void setShowing(boolean showing) {
        this.isShowing = showing;
    }


    /**
     * Renders this object onto the canvas
     * @param canvas the canvas to render onto
     */
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
