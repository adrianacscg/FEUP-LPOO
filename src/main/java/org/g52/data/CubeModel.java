package org.g52.data;

import java.util.ArrayList;
import java.util.List;

public class CubeModel {
    private final List<Cube> cubes;

    public CubeModel() {
        cubes = new ArrayList<>();
    }

    public List<Cube> getCubes() {
        return cubes;
    }

    public void addCube(Cube cube) {
        cubes.add(cube);
    }
}
