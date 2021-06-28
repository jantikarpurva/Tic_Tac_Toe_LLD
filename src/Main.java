import CheckWinnerStrategy.WinnerUsingTraditionalAlgo;
import Entities.*;

public class Main {

    public static void main(String[] args) {

        // function exposed to user doesn't have board or player object so they don't have access to getters and setters of board or players
        Game g = new Game(3, new HumanPlayer('X',"Purva"), new HumanPlayer('O',"Pratima"), new WinnerUsingTraditionalAlgo());
        g.launchGame();

    }
}
