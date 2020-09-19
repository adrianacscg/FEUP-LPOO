package org.g52.gui;

public class ViewFactory {
    public PlayerView getPlayerView() {
        return new PlayerView();
    }

    public CubeView getCubeView() {
        return new CubeView();
    }

    public OverlayView getOverlayView() {
        return new OverlayView();
    }

    public GameOverView getGameOverView() {
        return new GameOverView();
    }

    public GameStartView getGameStartView() {
        return new GameStartView();
    }

    public GamePauseView getGamePauseView() {
        return new GamePauseView();
    }
}
