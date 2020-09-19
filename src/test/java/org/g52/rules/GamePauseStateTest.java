package org.g52.rules;

import org.g52.data.*;
import org.g52.gui.ArenaView;
import org.g52.rules.gamestate.GamePauseState;
import org.g52.rules.gamestate.GameStartState;
import org.g52.rules.gamestate.GameState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class GamePauseStateTest {
    private ArenaController arenaController;
    private GamePauseState gamePauseState;

    @Before
    public void setup() {
        PlayerModel playerModel = new PlayerModel(5, 5);
        CubeModel cubeModel = new CubeModel();
        OverlayModel overlayModel = new OverlayModel();
        ArenaModel arenaModel = new ArenaModel(10, 10, playerModel, cubeModel, overlayModel);

        ControllerFactory controllerFactory = new ControllerFactory();
        arenaController = new ArenaController(Mockito.mock(ArenaView.class), arenaModel, controllerFactory);
        gamePauseState = new GamePauseState();
    }

    @Test
    public void execute() {
        gamePauseState.execute(ArenaView.COMMAND.ACCEPT, arenaController);

        assertEquals(GameState.class, arenaController.getCurrentState().getClass());
    }

    @Test
    public void executeNoAccept() {
        gamePauseState.execute(ArenaView.COMMAND.EOF, arenaController);

        assertEquals(GameStartState.class, arenaController.getCurrentState().getClass());
    }
}