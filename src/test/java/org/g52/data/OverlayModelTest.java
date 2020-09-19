package org.g52.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OverlayModelTest {
    private OverlayModel overlayModel;

    @Before
    public void setUp() {
        overlayModel = new OverlayModel();
    }

    @Test
    public void getScore() {
        assertEquals(0, overlayModel.getScore());
    }

    @Test
    public void setScore() {
        overlayModel.setScore(10);
        assertEquals(10, overlayModel.getScore());
    }
}