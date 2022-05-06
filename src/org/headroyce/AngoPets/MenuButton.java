package org.headroyce.AngoPets;

public class MenuButton extends Button {
    public MenuButton(double x, double y, double width, double height) {
        this.setIsOn(false);
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }
    public String getStage() {
        return "Menu";
    }
}
