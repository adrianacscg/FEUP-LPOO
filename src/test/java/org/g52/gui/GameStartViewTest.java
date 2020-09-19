package org.g52.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.g52.data.ArenaModel;
import org.junit.Test;
import org.mockito.Mockito;

public class GameStartViewTest {

    @Test
    public void draw() {
        TerminalScreen terminalScreen = Mockito.mock(TerminalScreen.class);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(terminalScreen.newTextGraphics()).thenReturn(textGraphics);

        ArenaModel arenaModel = Mockito.mock(ArenaModel.class);
        Mockito.when(arenaModel.getHeight()).thenReturn(30);
        Mockito.when(arenaModel.getWidth()).thenReturn(60);

        GameStartView gameStartView = new GameStartView();
        gameStartView.draw(terminalScreen, arenaModel);

        Mockito.verify(textGraphics).putString(25, 15, "CUBEFIELD");
        Mockito.verify(textGraphics).putString(20, 19, "PRESS ENTER TO START");
    }
}