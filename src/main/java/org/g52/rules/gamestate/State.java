package org.g52.rules.gamestate;

import org.g52.gui.ArenaView;
import org.g52.rules.ArenaController;

public interface State {
    void execute(ArenaView.COMMAND command, ArenaController controller);
}
