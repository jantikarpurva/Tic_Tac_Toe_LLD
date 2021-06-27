package Entities;

public class ComputerPlayer extends Players{
    String botLevel;

    public ComputerPlayer(char symbol,String name){
        super(symbol,name);
    }

    @Override
    public Position makeMove(char[][] board) {
        return new Position(0,0);
    }

    public String getBotLevel() {
        return botLevel;
    }

    public void setBotLevel(String botLevel) {
        this.botLevel = botLevel;
    }
}
