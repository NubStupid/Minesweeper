package tiles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MinesweeperBoard board = new MinesweeperBoard(9, 10, 10);
        Scanner sc = new Scanner(System.in);
        String in = new String();
        int x = -1;
        int y = -1;

        board.printBoard();
        while(true) {
            System.out.print("Masukkan input (0,2): ");
            in = sc.nextLine();
            x = Integer.parseInt(in.split(",")[0]);
            y = Integer.parseInt(in.split(",")[1]);
            board.buka(x, y);

            board.printBoard();
            if(board.checkBomb()){
                System.out.println("YOU LOSE!");
                break;
            }
            if(board.checkMenang()){
                System.out.println("YOU WIN!");
                break;
            }
        }
    }
}