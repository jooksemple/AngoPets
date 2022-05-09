package org.headroyce.AngoPets;

import javafx.scene.image.Image;

/**
 * Represents a specific type of AngoPet
 */
public class Snake extends Scales {

    public Snake() {
            img = new Image("file:PICS/babySnake.jpg");
            this.setIsSick(false);
            this.setHunger(0);
            this.setHappiness(0);
            this.setX(50);
            this.setY(50);
        }

    public Snake(double width, double height) {
            this.setWidth(width);
            this.setHeight(height);
            img = new Image("file:PICS/babySnake.jpg");
            this.setIsSick(false);
            this.setHunger(0);
            this.setHappiness(0);
            this.setX(50);
            this.setY(50);
        }

}
