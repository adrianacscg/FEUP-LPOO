package org.g52.rules;

import org.g52.data.ArenaModel;
import org.g52.data.OverlayModel;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class OverlayControllerTest {

    @Test
    public void executeCommand() {
        ArenaModel arenaModel = Mockito.mock(ArenaModel.class);
        OverlayModel overlayModel = new OverlayModel();

        Mockito.when(arenaModel.getOverlayModel()).thenReturn(overlayModel);

        OverlayController overlayController = new OverlayController();
        overlayController.executeCommand(arenaModel);

        assertEquals(1, arenaModel.getOverlayModel().getScore());
    }
}