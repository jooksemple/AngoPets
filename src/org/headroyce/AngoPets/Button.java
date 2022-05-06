package org.headroyce.AngoPets;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class Button {
    private double x, y, width, height;
    private String text;
    private Color color;

    public Button(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void setText(String text) {this.text = text; }
    public void setColor(Color color) {this.color = color; }
    public void render( Canvas canvas ) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(this.color);
        gc.fillRect(this.x, this.y, this.width, this.height);
        gc.setFill(this.color.invert());
        gc.fillText(this.text, this.x, this.y + this.height);
    }
}
