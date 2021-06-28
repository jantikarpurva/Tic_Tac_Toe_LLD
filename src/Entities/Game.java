package Entities;

import CheckWinnerStrategy.WinnerSelectionStrategy;

import java.util.Stack;

public class Game {
    Board gameBoard;
    Players player1;
    Players player2;
    WinnerSelectionStrategy winnerSelectionStrategy;
    Stack<Position> gameHistory = new Stack<>();

    public Game(int dimension, Players player1, Players player2, WinnerSelectionStrategy winnerSelectionStrategy){
        this.gameBoard = new Board(dimension);
        this.player1 = player1;
        this.player2 = player2;
        this.winnerSelectionStrategy = winnerSelectionStrategy;
    }

    public void printDetails(){
        gameBoard.printBoard();
        System.out.println("Board is of size "+ gameBoard.getBoard().length);
        System.out.println("Player 1 symbol "+player1.getSymbol());
        System.out.println("Player2 symbol "+ player2.getSymbol());
    }

    private boolean validPosition(int i, int j){
        return gameBoard.board[i][j]=='-';
    }

    public void launchGame(){
        printDetails();
        int maxTurns = gameBoard.board.length * gameBoard.board.length;
        int turns = 0;
        boolean player1Turn = true;
        boolean gameWon = false;
        while (turns < maxTurns){
            Players currentPlayer = player1Turn ? player1 : player2;
            Position position = currentPlayer.makeMove(this.gameBoard.board);
            while (!validPosition(position.getI(),position.getJ())){
                System.out.println("Oops something is here already ! Enter again ");
                position = currentPlayer.makeMove(this.gameBoard.board);
            }
            int i = position.getI();
            int j = position.getJ();
            gameHistory.add(position);
            this.gameBoard.board[i][j]=currentPlayer.getSymbol();
            this.gameBoard.printBoard();
            boolean winner = winnerSelectionStrategy.checkWinner(this.gameBoard.board, currentPlayer.getSymbol(), position);
            if(winner){
                System.out.println(currentPlayer.getPlayerName()+" is winner ");
                gameWon = true;
                break;
            }
            player1Turn = !player1Turn;
            turns++;
        }

        //System.out.println(gameHistory);
        if(!gameWon)
            System.out.println("No winners try again");
    }

}
