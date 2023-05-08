package tiles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MinesweeperBoard board = new MinesweeperBoard(10, 10);
        Scanner sc = new Scanner(System.in);
        String in = new String();

        board.printBoard();
        System.out.println("Masukkan input (0,2): ");
        in = sc.nextLine();
//        board.reveal(in);

    }
}