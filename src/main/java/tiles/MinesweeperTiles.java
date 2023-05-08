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

    public boolean isRevealed() {
        return revealed;
    }

    public void flipRevealed() {
        this.revealed = !revealed;
    }
}
