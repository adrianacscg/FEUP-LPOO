package org.g52.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerModelTest {
    private PlayerModel player;

    @Before
    public void setUp() {
        this.player = new PlayerModel(7, 0);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, player.getVelocity());
        assertEquals(7, player.getPosition().getX());
        assertEquals(0, player.getPosition().getY());
    }

    @Test
    public void testSetPosition() {
        player.setPosition(new Position(2, 3));

        assertEquals(2, player.getPosition().getX());
        assertEquals(3, player.getPosition().getY());
    }

    @Test
    public void testSetRelativeVelocity() {
        player.setRelativeVelocity(5);
        assertEquals(5, player.getVelocity());

        player.setRelativeVelocity(-2);
        assertEquals(3, player.getVelocity());
        
        player.setRelativeVelocity(5);
        assertEquals(8, player.getVelocity());
    }
}