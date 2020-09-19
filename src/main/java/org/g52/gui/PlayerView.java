package org.g52.gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import org.g52.data.PlayerModel;

public class PlayerView {
    public void draw(Screen screen, PlayerModel player) {
        screen.setCharacter(player.getPosition().getX(), player.getPosition().getY(), new TextCharacter((char)0x25b2));
    }
}
