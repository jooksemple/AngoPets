package org.headroyce.AngoPets;

import javafx.scene.image.Image;

public class Bear extends AngoPet {
    public Bear() {
        this.setX(50);
        this.setY(50);
    }

    public Bear(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        img = new Image("file:PICS/babyDefault.png");
        this.setIsSick(false);
        this.setHunger(0);
        this.setHappiness(0);
        this.setX(50);
        this.setY(50);
    }

    public void age(int age) {
        if (age >= 0 && age <= 5) {
            img = new Image("file:PICS/babyDefault.png");
        }
        if (age > 5 && age <= 15) {
            img = new Image("file:PICS/babyBear.png");
        }
    }
}
