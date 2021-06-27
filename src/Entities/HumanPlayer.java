package Entities;

import java.util.Scanner;

public class HumanPlayer extends Players{

    public HumanPlayer(char symbol, String name){
        super(symbol,name);
    }

    @Override
    public Position makeMove(char[][] board) {
        int boardDimension = board.length;
        System.out.println(this.getPlayerName()+" Enter position on board");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        boolean val = (i>=0 && i<boardDimension) && (j>=0 && j<boardDimension);
        while (!val){
            System.out.println(" Wrong coordinates ! Enter again ");
            i = sc.nextInt();
            j = sc.nextInt();
            val = (i>=0 && i<boardDimension) && (j>=0 && j<boardDimension);
        }
        return new Position(i,j);
    }
}
