package Entities;

public abstract class Players {
    private String playerName;
    private char symbol;

    public Players(char symbol, String playerName){
        this.symbol = symbol;
        this.playerName = playerName;
    }

    public abstract Position makeMove(char[][] board);

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
