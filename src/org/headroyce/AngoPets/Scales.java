package org.headroyce.AngoPets;

import javafx.scene.image.Image;

/**
 * Represents a specific type of AngoPet
 */
public class Scales extends AngoPet {

    public Scales() {
        img = new Image("file:PICS/baby.jpg");
        this.setIsSick(false);
        this.setHunger(0);
        this.setHappiness(0);
        this.setX(50);
        this.setY(50);
    }

    public Scales(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        img = new Image("file:PICS/baby.jpg");
        this.setIsSick(false);
        this.setHunger(0);
        this.setHappiness(0);
        this.setX(50);
        this.setY(50);
    }

}
