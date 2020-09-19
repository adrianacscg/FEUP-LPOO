package org.g52.rules.gamestate;

import org.g52.gui.ArenaView;
import org.g52.rules.ArenaController;

public class GamePauseState implements State {
    @Override
    public void execute(ArenaView.COMMAND command, ArenaController controller) {
        controller.getGui().drawGamePause(controller.getArena());

        if (command == ArenaView.COMMAND.ACCEPT) {
            controller.setCurrentState(new GameState());
        }
    }
}
