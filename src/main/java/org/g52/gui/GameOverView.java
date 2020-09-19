package org.g52.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.g52.data.ArenaModel;


public class GameOverView {
    public void draw(Screen screen, ArenaModel arena) {
        final long score = arena.getOverlayModel().getScore();
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        textGraphics.putString(arena.getWidth() / 2 - 3, arena.getHeight() / 2 - 3, "SCORE: ");
        textGraphics.putString(arena.getWidth() / 2 + 3, arena.getHeight() / 2 - 3, String.valueOf(score / 10));
        textGraphics.putString(arena.getWidth() / 2 - 4, arena.getHeight() / 2, "GAME OVER");
        textGraphics.putString(arena.getWidth() / 2 - 18, arena.getHeight() / 2 + 2, "PRESS ENTER TO PLAY AGAIN OR Q TO EXIT");
    }
}
