package org.headroyce.AngoPets;

/**
 * Represents the MenuButton
 */
public class MenuButton extends Button {

    public MenuButton(double x, double y, double width, double height) {

        this.setIsOn(false);
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }
    public void click() {
        if (isOn() == true) {
            setStage("StartingScreen");
        } else {
            setStage("Menu");
        }
        if (this.getIsShowing()) {
            this.setIsOn(!this.isOn());
        }

    }
}