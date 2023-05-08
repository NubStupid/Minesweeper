package Backtracking;
import tiles.Tiles;

import java.util.Random;
public class Algorithm{
    private int[][] map = new int[10][10];
    private String[][] UI = new String[10][10];
    public static void main(String[] args) {
        Algorithm app = new Algorithm();
        app.printMap();
        System.out.println();
        app.printUI();
        app.testRun(2,2);
        System.out.println();
        app.printUI();
        System.out.println();
        app.printMap();
    }
    public void testRun(int x,int y){
        if(map[x][y]!=0||x<0||x>9||y<0||y>9){
            return;
        }else{
//            printUI();
//            System.out.println();
            UI[x][y] = "XX";
            if(x+1<=9&&UI[x+1][y]!="XX")testRun(x+1,y);
            if(x-1>=0&&UI[x-1][y]!="XX")testRun(x-1,y);
            if(y+1<=9&&UI[x][y+1]!="XX")testRun(x,y+1);
            if(y-1>=0&&UI[x][y-1]!="XX")testRun(x,y-1);
            return;
        }
    }

    public Algorithm(){
        Random rand = new Random();
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                map[i][j] = 00;
                UI[i][j] = "[]";
            }
        }
        int count=0;
        do{
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            if(map[x][y]==0){
                map[x][y] = 2;
                count++;
            }
        }while(count!=30);

    }
    public void printMap(){
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void printUI(){
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if(UI[i][j]!="XX")
                System.out.print(UI[i][j]);
                else System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
