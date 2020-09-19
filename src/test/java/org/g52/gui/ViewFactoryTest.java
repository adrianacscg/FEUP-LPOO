package org.g52.gui;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewFactoryTest {
    private ViewFactory viewFactory;

    @Before
    public void setup() {
        viewFactory = new ViewFactory();
    }

    @Test
    public void getPlayerView() {
        assertEquals(viewFactory.getPlayerView().getClass(), PlayerView.class);
    }

    @Test
    public void getCubeView() {
        assertEquals(viewFactory.getCubeView().getClass(), CubeView.class);
    }

    @Test
    public void getOverlayView() {
        assertEquals(viewFactory.getOverlayView().getClass(), OverlayView.class);
    }

    @Test
    public void getGameOverView() {
        assertEquals(viewFactory.getGameOverView().getClass(), GameOverView.class);
    }

    @Test
    public void getGameStartView() {
        assertEquals(viewFactory.getGameStartView().getClass(), GameStartView.class);
    }

    @Test
    public void getGamePauseView() {
        assertEquals(viewFactory.getGamePauseView().getClass(), GamePauseView.class);
    }
}