package org.g52.rules.gamestate;

import org.g52.data.*;
import org.g52.gui.ArenaView;
import org.g52.rules.ArenaController;
import org.g52.rules.ControllerFactory;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class GameStateTest {

    @Test
    public void executePowerCube() {
        PlayerModel playerModel = Mockito.mock(PlayerModel.class);
        Mockito.when(playerModel.getPosition()).thenReturn(new Position(1, 3));
        CubeModel cubeModel = new CubeModel();
        cubeModel.addCube(new PowerCube(new Position(1, 2), 1));
        OverlayModel overlayModel = new OverlayModel();
        ArenaModel arenaModel = new ArenaModel(10, 10, playerModel, cubeModel, overlayModel);

        ControllerFactory controllerFactory = new ControllerFactory();
        ArenaController arenaController = new ArenaController(Mockito.mock(ArenaView.class), arenaModel, controllerFactory);

        GameState gameState = new GameState();
        gameState.execute(ArenaView.COMMAND.EOF, arenaController);

        assertEquals(501, arenaModel.getOverlayModel().getScore());
    }

    @Test
    public void executeNormalCube() {
        PlayerModel playerModel = new PlayerModel(1, 3);
        CubeModel cubeModel = new CubeModel();
        cubeModel.addCube(new NormalCube(new Position(1, 2), 1));
        OverlayModel overlayModel = new OverlayModel();
        ArenaModel arenaModel = new ArenaModel(10, 10, playerModel, cubeModel, overlayModel);
        arenaModel.setPlayerPosition(new Position(1, 3));
        ControllerFactory controllerFactory = new ControllerFactory();
        ArenaController arenaController = new ArenaController(Mockito.mock(ArenaView.class), arenaModel, controllerFactory);

        GameState gameState = new GameState();
        gameState.execute(ArenaView.COMMAND.EOF, arenaController);

        assertTrue(arenaModel.getCubeModel().getCubes().isEmpty());
        assertEquals(arenaModel.getPlayerModel().getPosition(), new Position(5, 9));
        assertEquals(GameOverState.class, arenaController.getCurrentState().getClass());
    }

    @Test
    public void executeACCEPT() {
        PlayerModel playerModel = new PlayerModel(1, 3);
        CubeModel cubeModel = new CubeModel();
        OverlayModel overlayModel = new OverlayModel();
        ArenaModel arenaModel = new ArenaModel(10, 10, playerModel, cubeModel, overlayModel);
        ControllerFactory controllerFactory = new ControllerFactory();
        ArenaController arenaController = new ArenaController(Mockito.mock(ArenaView.class), arenaModel, controllerFactory);

        GameState gameState = new GameState();
        gameState.execute(ArenaView.COMMAND.ACCEPT, arenaController);

        assertEquals(GamePauseState.class, arenaController.getCurrentState().getClass());
    }
}