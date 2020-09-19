package org.g52.rules;

import org.g52.data.ArenaModel;
import org.g52.data.Cube;
import org.g52.data.Position;
import org.g52.gui.ArenaView;

public class PlayerController {
    public void executeCommand(ArenaView.COMMAND command, ArenaModel arena) {
        switch (command) {
            case LEFT:
                handleLeftMovement(arena, -3, 1);
                break;
            case RIGHT:
                handleRightMovement(arena, 3, 1);
                break;
            default:
                handleDeceleration(arena, 1);
                break;
        }

        Position nextPosition = arena.getPlayerPosition().horizontalBy(arena.getPlayerVelocity());

        if (canMove(nextPosition, arena)) {
            arena.setPlayerPosition(nextPosition);
        }
    }

    private boolean canMove(Position position, ArenaModel arena) {
        return position.getX() >= 0 && position.getX() < arena.getWidth();
    }

    private void handleDeceleration(ArenaModel arena, int drag) {
        if (arena.getPlayerVelocity() > 0) {
            arena.setRelativePlayerVelocity(-drag);
        } else if (arena.getPlayerVelocity() < 0) {
            arena.setRelativePlayerVelocity(drag);
        }
    }

    private void handleLeftMovement(ArenaModel arena, int bottomSpeed, int speedIncrement) {
        if (arena.getPlayerVelocity() > bottomSpeed) {
            arena.setRelativePlayerVelocity(-speedIncrement);
        }
    }

    private void handleRightMovement(ArenaModel arena, int topSpeed, int speedIncrement) {
        if (arena.getPlayerVelocity() < topSpeed) {
            arena.setRelativePlayerVelocity(speedIncrement);
        }
    }

    public Cube checkCollision(ArenaModel arena) {
        for (Cube cube : arena.getCubeModel().getCubes()) {
            if (arena.getPlayerModel().getPosition().equals(cube.getPosition())) {
                return cube;
            }
        }
        return null;
    }
}
