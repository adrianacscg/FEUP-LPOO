package org.g52.gui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.g52.data.ArenaModel;
import org.g52.data.Cube;

import java.io.IOException;

public class ArenaView {
    private final Screen screen;
    private final PlayerView player;
    private final CubeView cubeView;
    private final OverlayView overlay;
    private final GameOverView gameover;
    private final GameStartView gameStart;
    private final GamePauseView gamePause;

    public enum COMMAND {ACCEPT, RIGHT, LEFT, EOF, NOOP}

    public ArenaView(Screen screen, ViewFactory view) throws IOException {
        this.screen = screen;
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        player = view.getPlayerView();
        cubeView = view.getCubeView();
        overlay = view.getOverlayView();
        gameover = view.getGameOverView();
        gameStart = view.getGameStartView();
        gamePause = view.getGamePauseView();
    }

    public void drawGame(ArenaModel arena) {
        screen.clear();

        for (Cube cube : arena.getCubeModel().getCubes()) {
            cubeView.draw(screen, cube);
        }

        player.draw(screen, arena.getPlayerModel());
        overlay.draw(screen, arena.getOverlayModel());

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawGameOver(ArenaModel arena) {
        screen.clear();
        gameover.draw(screen, arena);

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawGameStart(ArenaModel arena) {
        screen.clear();

        for (Cube cube : arena.getCubeModel().getCubes()) {
            cubeView.draw(screen, cube);
        }

        gameStart.draw(screen, arena);

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawGamePause(ArenaModel arena) {
        gamePause.draw(screen, arena);

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeScreen() throws IOException {
        screen.close();
    }

    public COMMAND getCommand() throws IOException {
        KeyStroke key = screen.pollInput();

        if (key == null) return COMMAND.NOOP;
        if (key.getKeyType() == KeyType.ArrowRight) return COMMAND.RIGHT;
        if (key.getKeyType() == KeyType.ArrowLeft) return COMMAND.LEFT;
        if (key.getKeyType() == KeyType.Enter) return COMMAND.ACCEPT;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') return COMMAND.EOF;
        if (key.getKeyType() == KeyType.EOF) return COMMAND.EOF;

        return COMMAND.NOOP;
    }
}
