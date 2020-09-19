package org.g52.data;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position verticalBy(int amount) {
        return new Position(this.x, this.y + amount);
    }

    public Position up() {
        return verticalBy(-1);
    }

    public Position down() {
        return verticalBy(1);
    }

    public Position horizontalBy(int amount) {
        return new Position(this.x + amount, this.y);
    }

    public Position right() {
        return horizontalBy(1);
    }

    public Position left() {
        return horizontalBy(-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
