package org.g52.rules;

import org.g52.data.ArenaModel;
import org.g52.data.CubeModel;
import org.g52.data.OverlayModel;
import org.g52.data.PlayerModel;
import org.g52.gui.ArenaView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ArenaControllerTest {
    private  ArenaController arenaController;
    private ArenaView gui;

    @Before
    public void setup() {
        PlayerModel playerModel = new PlayerModel(5, 5);
        ArenaModel arenaModel = new ArenaModel(10, 10, playerModel, new CubeModel(), new OverlayModel());
        ControllerFactory factory = new ControllerFactory();
        gui = Mockito.mock(ArenaView.class);

        arenaController = new ArenaController(gui, arenaModel, factory);

    }

    @Test
    public void executeCommandEOF() throws IOException {
        arenaController.executeCommand(ArenaView.COMMAND.EOF);
        Mockito.verify(gui).closeScreen();
    }

    @Test
    public void executeCommandNoEOF() throws IOException {
        arenaController.executeCommand(ArenaView.COMMAND.ACCEPT);
        Mockito.verify(gui, Mockito.never()).closeScreen();
    }
}