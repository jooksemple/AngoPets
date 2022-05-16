package org.headroyce.AngoPets;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.TextAlignment;

public class Spaceship {
        private Image img;
        private boolean isShowing;
        private double x, y, width, height;
        private Color color;
        private String text;

        public Spaceship() {
            img = new Image("file:PICS/Spaceship.png");
            isShowing = true;
            this.width = this.height = 20;
            this.x = this.y = 20;
        }
        public Spaceship(double x, double y, double width, double height) {
            img = new Image("file:PICS/Spaceship.png");
            isShowing = true;
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
        }

        public void setWidth(double width) {this.width = width; }
        public void setHeight(double height) {this.height = height; }
        public void setX(double x) {this.x = x; }
        public void setY(double y) {this.y = y; }

    public double getX() {return this.x;}
    public double getY() {return this.y;}
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
                gc.setFill(new ImagePattern(img));
                gc.fillRect(this.x, this.y, this.width, this.height);
            }
        }
    }

