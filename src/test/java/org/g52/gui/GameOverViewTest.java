package org.g52.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.g52.data.ArenaModel;
import org.g52.data.OverlayModel;
import org.junit.Test;
import org.mockito.Mockito;

public class GameOverViewTest {

    @Test
    public void draw() {
        TerminalScreen terminalScreen = Mockito.mock(TerminalScreen.class);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(terminalScreen.newTextGraphics()).thenReturn(textGraphics);

        ArenaModel arenaModel = Mockito.mock(ArenaModel.class);
        Mockito.when(arenaModel.getHeight()).thenReturn(30);
        Mockito.when(arenaModel.getWidth()).thenReturn(60);

        OverlayModel overlayModel = Mockito.mock(OverlayModel.class);
        Mockito.when(overlayModel.getScore()).thenReturn((long) 100);
        Mockito.when(arenaModel.getOverlayModel()).thenReturn(overlayModel);

        GameOverView gameOverView = new GameOverView();
        gameOverView.draw(terminalScreen, arenaModel);

        Mockito.verify(textGraphics).putString(27, 12, "SCORE: ");
        Mockito.verify(textGraphics).putString(33, 12, "10");
        Mockito.verify(textGraphics).putString(26, 15, "GAME OVER");
        Mockito.verify(textGraphics).putString(12, 17, "PRESS ENTER TO PLAY AGAIN OR Q TO EXIT");
    }
}