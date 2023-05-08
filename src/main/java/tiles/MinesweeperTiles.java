package tiles;

public class MinesweeperTiles {
    private Tiles tiles;
    private boolean revealed;

    public MinesweeperTiles(Tiles tiles) {
        this.tiles = tiles;
        this.revealed = false;
    }

    public Tiles getTiles() {
        return this.tiles;
    }
}
