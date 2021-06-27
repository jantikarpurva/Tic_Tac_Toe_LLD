package CheckWinnerStrategy;

import Entities.Board;
import Entities.Position;

public interface WinnerSelectionStrategy {
    public boolean checkWinner(char[][] board, char symbol, Position position);
}
