package org.g52.rules;

import org.g52.data.ArenaModel;
import org.g52.gui.ArenaView;
import org.g52.rules.gamestate.GameStartState;
import org.g52.rules.gamestate.State;

import java.io.IOException;

public class ArenaController {
    private final ArenaView gui;
    private final PlayerController player;
    private final CubeController cube;
    private final OverlayController overlay;
    private final ArenaModel arena;

    private State currentState;
    private long frameCounter;

    public ArenaController(ArenaView gui, ArenaModel arena, ControllerFactory factory) {
        this.arena = arena;
        this.gui = gui;

        this.player = factory.getPlayerController();
        this.cube = factory.getCubeController();
        this.overlay = factory.getOverlayController();

        this.currentState = new GameStartState();
        this.frameCounter = 0;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public long getFrameCounter() {
        return frameCounter;
    }

    public ArenaView getGui() {
        return gui;
    }

    public PlayerController getPlayer() {
        return player;
    }

    public CubeController getCube() {
        return cube;
    }

    public OverlayController getOverlay() {
        return overlay;
    }

    public ArenaModel getArena() {
        return arena;
    }

    public void executeCommand(ArenaView.COMMAND command) throws IOException {
        if (command == ArenaView.COMMAND.EOF) gui.closeScreen();
    }

    public void start() throws IOException, InterruptedException {
        ArenaView.COMMAND command = ArenaView.COMMAND.NOOP;

        while (command != ArenaView.COMMAND.EOF) {
            long start = System.currentTimeMillis();
            command = gui.getCommand();

            this.executeCommand(command);
            currentState.execute(command, this);

            this.frameCounter += 1;

            long millis = start + 35 - System.currentTimeMillis();
            millis = millis < 0 ? 0 : millis;
            Thread.sleep(millis);
        }
    }
}
