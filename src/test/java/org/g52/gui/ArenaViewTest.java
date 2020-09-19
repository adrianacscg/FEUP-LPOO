package org.g52.gui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.*;

public class ArenaViewTest {
    private ViewFactory viewFactory;
    private Screen screen;
    private KeyStroke keyStroke;

    @Before
    public void setup() {
        viewFactory = new ViewFactory();
        screen = Mockito.mock(Screen.class);
        keyStroke = Mockito.mock(KeyStroke.class);
    }

    @Test
    public void getCommandNOOP() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(null);

        ArenaView arenaView = new ArenaView(screen, viewFactory);
        assertEquals(ArenaView.COMMAND.NOOP, arenaView.getCommand());

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Backspace);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        arenaView = new ArenaView(screen, viewFactory);
        assertEquals(ArenaView.COMMAND.NOOP, arenaView.getCommand());
    }

    @Test
    public void getCommandRIGHT() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        ArenaView arenaView = new ArenaView(screen, viewFactory);
        assertEquals(ArenaView.COMMAND.RIGHT, arenaView.getCommand());
    }

    @Test
    public void getCommandLEFT() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        ArenaView arenaView = new ArenaView(screen, viewFactory);
        assertEquals(ArenaView.COMMAND.LEFT, arenaView.getCommand());
    }

    @Test
    public void getCommandACCEPT() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        ArenaView arenaView = new ArenaView(screen, viewFactory);
        assertEquals(ArenaView.COMMAND.ACCEPT, arenaView.getCommand());
    }

    @Test
    public void getCommandEOF() throws IOException {
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyStroke.getCharacter()).thenReturn('q');

        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        ArenaView arenaView = new ArenaView(screen, viewFactory);
        assertEquals(ArenaView.COMMAND.EOF, arenaView.getCommand());

        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.EOF);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        arenaView = new ArenaView(screen, viewFactory);
        assertEquals(ArenaView.COMMAND.EOF, arenaView.getCommand());
    }
}