package Entities;

public class Board {
    char[][] board;

    public Board(int dimension){
        board = new char[dimension][dimension];
        populateBoard();
    }

    void populateBoard(){
        for (int i=0;i<board.length;i++){
            for (int j=0;j< board.length;j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard(){
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println(" ");
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }
}
