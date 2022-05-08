package org.headroyce.AngoPets;

public class PlayButton extends Button {

    public PlayButton(double x, double y, double width, double height) {
        this.setIsOn(false);
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }
    public String getStage() {
        return "Play";
    }
}