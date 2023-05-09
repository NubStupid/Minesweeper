package tiles;

import java.util.Random;
public class MinesweeperBoard    {
    private int row;
    private int column;
    private int bomb;
    private MinesweeperTiles[][] boardGame;
    public MinesweeperBoard(int row, int column, int bomb) {
        this.row = row;
        this.column = column;
        this.bomb = bomb;
        this.boardGame = new MinesweeperTiles[row][column] ;
        this.buildBoard();
        this.randBomb();
    }

    public boolean checkBomb(){
        for(int i=0; i<column; i++){
            for(int j=0; j<row; j++){
                if(boardGame[j][i].getTiles().equals(Tiles.BOMB) && boardGame[j][i].isRevealed()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkMenang(){
        int ctr = 0;
        for(int i=0; i<column; i++){
            for(int j=0; j<row; j++){
                if(!boardGame[j][i].isRevealed()){
                    ctr++;
                }
            }
        }

        if(ctr == bomb){
            return true;
        }
        return false;
    }

    public void buka(int x, int y){
        if(x<0||x>row-1||y<0||y>column-1){
            return;
        }
        else if(!boardGame[x][y].getTiles().equals(Tiles.EMPTY)){
            boardGame[x][y].flipRevealed();
        }
        else{
            boardGame[x][y].flipRevealed();
            if(x+1<= row-1 &&!boardGame[x+1][y].isRevealed())buka(x+1,y);
            if(x-1>=0&&!boardGame[x-1][y].isRevealed())buka(x-1,y);
            if(y+1<= column-1 &&!boardGame[x][y+1].isRevealed())buka(x,y+1);
            if(y-1>=0&&!boardGame[x][y-1].isRevealed())buka(x,y-1);
            if(x+1<= row-1 && y+1<= column-1 && !boardGame[x+1][y+1].isRevealed())buka(x+1,y+1);
            if(x-1>= 0 && y-1>= 0 && !boardGame[x-1][y-1].isRevealed())buka(x-1,y-1);
            if(x+1<= row-1 && y-1>= 0 && !boardGame[x+1][y-1].isRevealed())buka(x+1,y-1);
            if(x-1>= 0 && y+1<= column-1 && !boardGame[x-1][y+1].isRevealed())buka(x-1,y+1);
        }
    }

    private void buildBoard() {
        for(int i = 0; i < column; i++) {
            for(int j = 0; j < row; j++) {
                this.boardGame[j][i] = new MinesweeperTiles(Tiles.EMPTY);
            }
        }
    }

    private void randBomb(){
        Random rand = new Random();
        int count=0;
        do{
            int x = rand.nextInt(row);
            int y = rand.nextInt(column);
            if(boardGame[x][y].getTiles().equals(Tiles.EMPTY)){
                boardGame[x][y] = new MinesweeperTiles(Tiles.BOMB);
                count++;
            }
        }while(count!=bomb);

        for(int i=0; i<column; i++){
            for(int j=0; j<row; j++){
                generateAngka(j, i);
            }
        }
    }

    private void generateAngka(int x, int y){
        int ctr = 0;
        if(boardGame[x][y].getTiles().equals(Tiles.BOMB)){
            ;
        }
        else if(x==0 & y==0){
            if(boardGame[x+1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x+1][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }

            boardGame[x][y] = new MinesweeperTiles(besar(ctr));
        }
        else if(x==row-1 & y==column-1){
            if(boardGame[x-1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x-1][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }

            boardGame[x][y] = new MinesweeperTiles(besar(ctr));
        }
        else if(x==0 & y==column-1){
            if(boardGame[x+1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x+1][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }

            boardGame[x][y] = new MinesweeperTiles(besar(ctr));
        }
        else if(x==row-1 & y==0){
            if(boardGame[x-1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x-1][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }

            boardGame[x][y] = new MinesweeperTiles(besar(ctr));
        }
        else if(x==0){
            if(boardGame[x+1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x+1][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x+1][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }

            boardGame[x][y] = new MinesweeperTiles(besar(ctr));
        }
        else if(y==0){
            if(boardGame[x+1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x+1][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x-1][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x-1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }

            boardGame[x][y] = new MinesweeperTiles(besar(ctr));
        }
        else if(x==row-1){
            if(boardGame[x-1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x-1][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x-1][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }

            boardGame[x][y] = new MinesweeperTiles(besar(ctr));
        }
        else if(y==column-1){
            if(boardGame[x+1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x+1][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x-1][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x-1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }

            boardGame[x][y] = new MinesweeperTiles(besar(ctr));
        }
        else{
            if(boardGame[x+1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x+1][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x-1][y-1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x-1][y].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x-1][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }
            if(boardGame[x+1][y+1].getTiles().equals(Tiles.BOMB)){
                ctr++;
            }

            boardGame[x][y] = new MinesweeperTiles(besar(ctr));
        }
    }

    private Tiles besar(int ctr){

        if(ctr == 0){
            return Tiles.EMPTY;
        }
        else if(ctr == 1){
            return Tiles.ONE;
        }
        else if(ctr == 2){
            return Tiles.TWO;
        }
        else if(ctr == 3){
            return Tiles.THREE;
        }
        else if(ctr == 4){
            return Tiles.FOUR;
        }
        else if(ctr == 5){
            return Tiles.FIVE;
        }
        else if(ctr == 6){
            return Tiles.SIX;
        }
        else if(ctr == 7){
            return Tiles.SEVEN;
        }
        else if(ctr == 8){
            return Tiles.EIGHT;
        }
        return Tiles.EMPTY;
    }

    public void printBoard() {
        for(int i = 0; i < this.column; i++) {
            for(int j = 0; j < this.row; j++) {
                MinesweeperTiles mtTiles = this.boardGame[j][i];
                System.out.print("[");
                System.out.print(this.tilesToString(mtTiles.getTiles(), mtTiles.isRevealed()));
                System.out.print("] ");
            }
            System.out.print(i);
            System.out.println();
        }
        for(int k = 0; k < this.row; k++) {
            System.out.print(" " + k + "  ");
        }
        System.out.println("");
    }

    private String tilesToString(Tiles tilesToCheck, boolean isRevealed) {
        if(!isRevealed) {
            return "X";
        }

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
        }
        return null;
    }
}
