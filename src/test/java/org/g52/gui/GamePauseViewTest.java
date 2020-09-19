package org.g52.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.g52.data.ArenaModel;
import org.junit.Test;
import org.mockito.Mockito;

public class GamePauseViewTest {

    @Test
    public void draw() {
        TerminalScreen terminalScreen = Mockito.mock(TerminalScreen.class);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(terminalScreen.newTextGraphics()).thenReturn(textGraphics);

        ArenaModel arenaModel = Mockito.mock(ArenaModel.class);
        Mockito.when(arenaModel.getHeight()).thenReturn(30);
        Mockito.when(arenaModel.getWidth()).thenReturn(60);

        GamePauseView gamePauseView = new GamePauseView();
        gamePauseView.draw(terminalScreen, arenaModel);

        Mockito.verify(textGraphics).putString(27, 15, "PAUSED");
        Mockito.verify(textGraphics).putString(20, 17, "PRESS ENTER TO RESUME");
    }
}