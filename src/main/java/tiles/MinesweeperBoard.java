package tiles;

public class MinesweeperBoard    {
    private int row;
    private int column;
    private MinesweeperTiles[][] boardGame;
    public MinesweeperBoard(int row, int column) {
        this.row = row;
        this.column = column;
        this.boardGame = new MinesweeperTiles[row][column];
        this.buildBoard();
    }

    private void buildBoard() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                this.boardGame[i][j] = new MinesweeperTiles(Tiles.EMPTY);
            }
        }
    }

    public void printBoard() {
        for(MinesweeperTiles[] mt : this.boardGame) {
            for(MinesweeperTiles mtTiles : mt) {
                System.out.print("[");
                System.out.print(this.tilesToString(mtTiles.getTiles()));
                System.out.print("] ");
            }
            System.out.println();
        }
    }

    private String tilesToString(Tiles tilesToCheck) {
        switch(tilesToCheck) {
            case ONE -> {
                return "1";
            }
            case TWO -> {
                return "2";
            }
            case THREE -> {
                return "3";
            }
            case FOUR -> {
                return "4";
            }
            case FIVE -> {
                return "5";
            }
            case SIX -> {
                return "6";
            }
            case SEVEN -> {
                return "7";
            }
            case EIGHT -> {
                return "8";
            }
            case BOMB -> {
                return "B";
            }
            case EMPTY -> {
                return " ";
            }
            case FLAG -> {
                return "F";
            }
        }
        return null;
    }
}
