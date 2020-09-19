package org.g52.rules.gamestate;

import org.g52.gui.ArenaView;
import org.g52.rules.ArenaController;

public class GameStartState implements State {
    @Override
    public void execute(ArenaView.COMMAND command, ArenaController controller) {
        controller.getCube().executeCommand(controller.getFrameCounter(), controller.getArena());
        controller.getGui().drawGameStart(controller.getArena());

        if (command == ArenaView.COMMAND.ACCEPT) {
            controller.getCube().removeAllCubes(controller.getArena());
            controller.setCurrentState(new GameState());
        }
    }
}
