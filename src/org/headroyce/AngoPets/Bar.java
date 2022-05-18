package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class Bar {
    private boolean isShowing;
    private double x, y, width, height;
    private Color color;
    private String text;
    public Bar() {
        isShowing = true;
        this.width = this.height = 30;
        this.x = this.y = 20;
    }
    public Bar(double x, double y, double width, double height) {
        isShowing = true;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    public void setWidth(double width) {this.width = width; }
    public void setHeight(double height) {this.height = height; }
    public void setText(String text) {this.text = text; }
    public void setX(double x) {this.x = x; }
    public void setY(double y) {this.y = y; }
    public void setColor(Color color) {this.color = color; }
    public void setShowing(boolean showing) {
        this.isShowing = showing;
    }
    public double getWidth() {return this.width; }
    public double getHeight() {return this.height; }
    public boolean isShowing() {
        return this.isShowing;
    }
    public String getText() { return this.text;}


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
