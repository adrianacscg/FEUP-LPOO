package org.g52.rules;

import org.g52.data.*;
import org.g52.gui.ArenaView;
import org.g52.rules.gamestate.GameOverState;
import org.g52.rules.gamestate.GameStartState;
import org.g52.rules.gamestate.GameState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class GameOverStateTest {
    private OverlayModel overlayModel;
    private ArenaController arenaController;
    private GameOverState gameOverState;

    @Before
    public void setup() {
        PlayerModel playerModel = new PlayerModel(5, 5);
        CubeModel cubeModel = new CubeModel();
        cubeModel.addCube(new NormalCube(new Position(1, 2), 1));
        overlayModel = new OverlayModel();
        ArenaModel arenaModel = new ArenaModel(10, 10, playerModel, cubeModel, overlayModel);

        ControllerFactory controllerFactory = new ControllerFactory();
        arenaController = new ArenaController(Mockito.mock(ArenaView.class), arenaModel, controllerFactory);

        gameOverState = new GameOverState();
    }

    @Test
    public void execute() {
        overlayModel.setScore(5);
        gameOverState.execute(ArenaView.COMMAND.ACCEPT, arenaController);

        assertEquals(0, overlayModel.getScore());
        assertEquals(GameState.class, arenaController.getCurrentState().getClass());
    }

    @Test
    public void executeNoAccept() {
        gameOverState.execute(ArenaView.COMMAND.EOF, arenaController);

        assertEquals(0, overlayModel.getScore());
        assertEquals(GameStartState.class, arenaController.getCurrentState().getClass());
    }
}