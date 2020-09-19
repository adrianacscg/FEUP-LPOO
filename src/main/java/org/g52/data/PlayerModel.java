package org.g52.data;

public class PlayerModel extends Element {
    private int velocity;

    public PlayerModel(int x, int y) {
        super(x, y);
        velocity = 0;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setRelativeVelocity(int offset) {
        this.velocity = velocity + offset;
    }
}
