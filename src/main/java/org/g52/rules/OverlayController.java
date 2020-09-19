package org.g52.rules;

import org.g52.data.ArenaModel;
import org.g52.data.OverlayModel;

public class OverlayController {
    public void executeCommand(ArenaModel arena) {
        OverlayModel model = arena.getOverlayModel();
        model.setScore(model.getScore() + 1);
    }
}
