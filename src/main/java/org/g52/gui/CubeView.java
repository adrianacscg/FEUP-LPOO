package org.g52.gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import org.g52.data.Cube;
import org.g52.data.NormalCube;
import org.g52.data.PowerCube;

public class CubeView {
    public void draw(Screen screen, Cube cube) {
        if (cube instanceof NormalCube) {
            screen.setCharacter(cube.getPosition().getX(), cube.getPosition().getY(), new TextCharacter((char) 0x25a1));
        } else if (cube instanceof PowerCube) {
            TextGraphics textGraphics = screen.newTextGraphics();
            textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
            textGraphics.putString(cube.getPosition().getX(), cube.getPosition().getY(), String.valueOf((char) 0x25a0));
        }
    }
}
