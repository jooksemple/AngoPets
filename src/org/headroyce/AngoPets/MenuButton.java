package org.headroyce.AngoPets;

/**
 * Represents the MenuButton
 */
public class MenuButton extends Button {
    private String rtnString;
    public MenuButton(double x, double y, double width, double height) {
        this.setIsOn(false);
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }
    public void click() {
        if (isOn() == true) {
            rtnString = "StartingScreen";
        } else {
            rtnString = "Menu";
        }

        if (this.getIsShowing()) {
            this.setIsOn(!this.isOn());
        }
    }
    public String getStage() {
        return rtnString;
    }
}