package org.g52.rules.gamestate;

import org.g52.data.NormalCube;
import org.g52.data.Position;
import org.g52.data.PowerCube;
import org.g52.gui.ArenaView;
import org.g52.rules.ArenaController;

public class GameState implements State {
    @Override
    public void execute(ArenaView.COMMAND command, ArenaController controller) {
        controller.getPlayer().executeCommand(command, controller.getArena());
        controller.getCube().executeCommand(controller.getFrameCounter(), controller.getArena());
        controller.getOverlay().executeCommand(controller.getArena());
        controller.getGui().drawGame(controller.getArena());

        if (controller.getPlayer().checkCollision(controller.getArena()) instanceof NormalCube) {
            controller.getCube().removeAllCubes(controller.getArena());
            controller.getArena().setPlayerPosition(new Position(controller.getArena().getWidth() / 2, controller.getArena().getHeight() - 1));

            controller.setCurrentState(new GameOverState());
        } else if (controller.getPlayer().checkCollision(controller.getArena()) instanceof PowerCube) {
            controller.getArena().getOverlayModel().setScore(controller.getArena().getOverlayModel().getScore() + 500);
        } else if (command == ArenaView.COMMAND.ACCEPT) {
            controller.setCurrentState(new GamePauseState());
        }
    }
}
