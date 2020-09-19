package org.g52.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.g52.data.OverlayModel;

public class OverlayView {
    public void draw(Screen screen, OverlayModel overlay) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        textGraphics.putString(4, 2, String.valueOf(overlay.getScore() / 10));
    }
}
