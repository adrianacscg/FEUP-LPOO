package org.g52.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.g52.data.OverlayModel;
import org.junit.Test;
import org.mockito.Mockito;

public class OverlayViewTest {

    @Test
    public void draw() {
        TerminalScreen terminalScreen = Mockito.mock(TerminalScreen.class);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(terminalScreen.newTextGraphics()).thenReturn(textGraphics);

        OverlayModel overlayModel = Mockito.mock(OverlayModel.class);
        Mockito.when(overlayModel.getScore()).thenReturn((long) 100);

        OverlayView overlayView = new OverlayView();
        overlayView.draw(terminalScreen, overlayModel);

        Mockito.verify(textGraphics).putString(4, 2, "10");
    }
}