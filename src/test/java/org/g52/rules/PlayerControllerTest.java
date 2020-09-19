package org.g52.rules;

import org.g52.data.*;
import org.g52.gui.ArenaView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerControllerTest {

    @Test
    public void checkCollision() {
        PlayerModel playerModel = Mockito.mock(PlayerModel.class);
        Mockito.when(playerModel.getPosition()).thenReturn(new Position(10, 10));

        CubeModel cubeModel = new CubeModel();
        NormalCube normalCube = Mockito.mock(NormalCube.class);
        Mockito.when(normalCube.getPosition()).thenReturn(new Position(10, 10));
        cubeModel.addCube(normalCube);

        ArenaModel arenaModel = new ArenaModel(60, 30, playerModel, cubeModel, new OverlayModel());
        PlayerController playerController = new PlayerController();
        assertEquals(normalCube, playerController.checkCollision(arenaModel));
    }

    @Test
    public void checkNoCollision() {
        PlayerModel playerModel = Mockito.mock(PlayerModel.class);
        Mockito.when(playerModel.getPosition()).thenReturn(new Position(10, 10));

        CubeModel cubeModel = new CubeModel();
        NormalCube normalCube = Mockito.mock(NormalCube.class);
        Mockito.when(normalCube.getPosition()).thenReturn(new Position(20, 20));
        cubeModel.addCube(normalCube);

        ArenaModel arenaModel = new ArenaModel(60, 30, playerModel, cubeModel, new OverlayModel());
        PlayerController playerController = new PlayerController();
        assertNull(playerController.checkCollision(arenaModel));
    }

    @Test
    public void executeCommandLeft() {
        PlayerModel playerModel = new PlayerModel(10, 10);
        CubeModel cubeModel = new CubeModel();
        OverlayModel overlayModel = new OverlayModel();

        ArenaModel arenaModel = new ArenaModel(60, 30, playerModel, cubeModel, overlayModel);
        PlayerController playerController = new PlayerController();
        playerController.executeCommand(ArenaView.COMMAND.LEFT, arenaModel);

        assertEquals(arenaModel.getPlayerModel().getPosition(), new Position(29, 29));
    }

    @Test
    public void executeCommandRight() {
        PlayerModel playerModel = new PlayerModel(10, 10);
        CubeModel cubeModel = new CubeModel();
        OverlayModel overlayModel = new OverlayModel();

        ArenaModel arenaModel = new ArenaModel(60, 30, playerModel, cubeModel, overlayModel);
        PlayerController playerController = new PlayerController();
        playerController.executeCommand(ArenaView.COMMAND.RIGHT, arenaModel);

        assertEquals(arenaModel.getPlayerModel().getPosition(), new Position(31, 29));
    }

    @Test
    public void executeCommandDefault() {
        PlayerModel playerModel = new PlayerModel(10, 10);
        playerModel.setRelativeVelocity(1);
        CubeModel cubeModel = new CubeModel();
        OverlayModel overlayModel = new OverlayModel();

        ArenaModel arenaModel = new ArenaModel(60, 30, playerModel, cubeModel, overlayModel);
        PlayerController playerController = new PlayerController();
        playerController.executeCommand(ArenaView.COMMAND.EOF, arenaModel);

        assertEquals(arenaModel.getPlayerModel().getVelocity(), 0);
        assertEquals(arenaModel.getPlayerModel().getPosition(), new Position(30, 29));
    }
}