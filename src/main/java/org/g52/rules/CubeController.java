package org.g52.rules;

import org.g52.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CubeController {
    private final int cubeAmount;
    private final int maxSpeed;

    public CubeController(int cubeAmount, int maxSpeed) {
        this.cubeAmount = cubeAmount;
        this.maxSpeed = maxSpeed;
    }

    private void cubeFlow(ArenaModel arena) {
        makeNewCubes(arena);
        makeCubesFall(arena);
        removeFallenCubes(arena);
    }

    private void makeNewCubes(ArenaModel arena) {
        CubeModel cube = arena.getCubeModel();

        if (cube.getCubes().size() < cubeAmount) {
            Random random = new Random();
            if (random.nextFloat() < 0.9)
                cube.addCube(new NormalCube(new Position(random.nextInt(arena.getWidth()), 0) , this.maxSpeed));
            else
                cube.addCube(new PowerCube(new Position(random.nextInt(arena.getWidth()), 0) , this.maxSpeed));
        }
    }

    private void makeCubesFall(ArenaModel arena) {
        CubeModel cubeModel = arena.getCubeModel();

        List<Cube> cubes = cubeModel.getCubes();
        for (Cube cube : cubes)
            cube.setPosition(cube.getPosition().verticalBy(cube.getSpeed()));
    }

    private void removeFallenCubes(ArenaModel arena) {
        CubeModel cubeModel = arena.getCubeModel();

        List<Cube> cubes = cubeModel.getCubes();
        List<Cube> toRemove = new ArrayList<>();

        for (Cube cube : cubes)
            if (cube.getPosition().getY() == arena.getHeight())
                toRemove.add(cube);

        cubes.removeAll(toRemove);
    }

    public void removeAllCubes(ArenaModel arena) {
        CubeModel cubeModel = arena.getCubeModel();

        List<Cube> cubes = cubeModel.getCubes();
        cubes.clear();
    }

    public void executeCommand(long frames, ArenaModel arena) {
        if (frames % 2 == 0) {
            cubeFlow(arena);
        }
    }
}
