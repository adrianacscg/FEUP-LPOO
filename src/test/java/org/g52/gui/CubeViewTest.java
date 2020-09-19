package org.g52.gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.g52.data.NormalCube;
import org.g52.data.Position;
import org.g52.data.PowerCube;
import org.junit.Test;
import org.mockito.Mockito;

public class CubeViewTest {

    @Test
    public void drawNormalCube() {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        NormalCube cube = Mockito.mock(NormalCube.class);

        Mockito.when(cube.getPosition()).thenReturn(new Position(1, 2));

        CubeView cubeView = new CubeView();
        cubeView.draw(screen, cube);

        Mockito.verify(screen, Mockito.times(1))
                .setCharacter(1, 2, new TextCharacter((char) 0x25a1));
    }

    @Test
    public void drawPowerCube() {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        PowerCube powerCube = Mockito.mock(PowerCube.class);
        Mockito.when(powerCube.getPosition()).thenReturn(new Position(1, 2));

        CubeView cubeView = new CubeView();
        cubeView.draw(screen, powerCube);
        Mockito.verify(textGraphics).setForegroundColor(TextColor.ANSI.GREEN);
        Mockito.verify(textGraphics).putString(1, 2, String.valueOf((char) 0x25a0));
    }
}