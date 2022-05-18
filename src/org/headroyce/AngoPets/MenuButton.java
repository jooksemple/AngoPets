package org.headroyce.AngoPets;

/**
 * Represents the MenuButton
 */
public class MenuButton extends Button {

    /**
     * Creates a Menu Button with custom coordinates, width, and height
     * @param x the X coordinate of the button
     * @param y the Y coordinate of the button
     * @param width the width of the button
     * @param height the height of the button
     */
    public MenuButton(double x, double y, double width, double height) {
        this.setIsOn(false);
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }

    /**
     * Sets the stage and what to do when clicked
     */
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