package org.g52.rules;

public class ControllerFactory {
    public PlayerController getPlayerController() {
        return new PlayerController();
    }

    public CubeController getCubeController() {
        return new CubeController(30, 1);
    }

    public OverlayController getOverlayController() {
        return new OverlayController();
    }
}
