package CheckWinnerStrategy;

import Entities.Position;

public class WinnerUsingTraditionalAlgo implements WinnerSelectionStrategy{
    int boardDimension;
    char[][] board ;
    char symbol ;

    private boolean compareSymbol(int i, int j){
        if(board[i][j]==symbol)
            return true;
        else{
            return false;
        }
    }

    @Override
    public boolean checkWinner(char[][] gameBoard, char gameSymbol, Position position) {
        board = gameBoard;
        boardDimension = board.length;
        symbol = gameSymbol;

        int row = position.getI();
        int column = position.getJ();
        boolean result = false;
        boolean belongsToDiagonal = ((row == column) || (row+column == boardDimension-1));

        // if its 0,2 check for 1,col - if in a row all matches
        for(int c=0;c<boardDimension;c++){
            result = compareSymbol(row,c);
            if(!result)
                break;
        }
        if (result)
            return true;


        // if its 1,0 check for row,0 - if in col all matches
        for (int r=0;r<boardDimension;r++){
            result = compareSymbol(r,column);
            if(!result)
                break;
        }
        if(result)
            return true;

        // if row and col doesn't match check for diagonal only if coordinates belong to diagonal
        if(belongsToDiagonal){
            // diagonal 1
            for(int i=0;i<boardDimension;i++){
                result = compareSymbol(i,i);
                if(!result)
                    break;
            }
            if (result)
                return true;

            // diagonal 2
            for(int i=0;i<boardDimension;i++){
                result = compareSymbol(i,(boardDimension-i-1));
                if(!result)
                    break;
            }
            return result;
        }
        return false;
    }
}
