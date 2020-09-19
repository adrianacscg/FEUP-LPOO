package org.g52.data;

public class ArenaModel {
    private final int width;
    private final int height;
    private final PlayerModel player;
    private final CubeModel cube;
    private final OverlayModel overlay;


    public ArenaModel(int width, int height, PlayerModel player, CubeModel cube, OverlayModel overlay) {
        this.width = width;
        this.height = height;
        this.player = player;
        this.player.setPosition(new Position(width / 2, height - 1));

        this.cube = cube;
        this.overlay = overlay;
    }

    public PlayerModel getPlayerModel() {
        return player;
    }

    public Position getPlayerPosition() {
        return player.getPosition();
    }

    public int getPlayerVelocity() {
        return player.getVelocity();
    }

    public void setRelativePlayerVelocity(int offset) {
        player.setRelativeVelocity(offset);
    }

    public void setPlayerPosition(Position position) {
        player.setPosition(position);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public CubeModel getCubeModel(){ return cube; }

    public OverlayModel getOverlayModel() {return overlay;}
}
