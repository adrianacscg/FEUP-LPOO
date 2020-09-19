package org.g52.data;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CubeTest {
    private Cube cube;

    @Before
    public void setUp() {
        Position position = Mockito.mock(Position.class);
        Mockito.when(position.getX()).thenReturn(5);
        Mockito.when(position.getY()).thenReturn(10);

        cube = new NormalCube(position, 30);
    }

    @Test
    public void testConstructor() {
        assertEquals(5, cube.getPosition().getX());
        assertEquals(10, cube.getPosition().getY());
    }

    @Test
    public void getSpeed() {
        assertEquals(30, cube.getSpeed());
    }
}