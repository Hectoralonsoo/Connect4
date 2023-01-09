package Model;

public class Turn implements ITurn{
    private Player[] players;
    private static final int NUMBER_PLAYERS = 2;

    private int activePlayer;

    Turn(){
        this.players = new Player[NUMBER_PLAYERS];
        this.reset();
    }
     private void reset(){
        for(int i = 0; i < NUMBER_PLAYERS; i++){
            this.players[i] = new Human(Color.get(i));
        }
        this.activePlayer = 0;
    }
    public int getActivePlayer(){
        return activePlayer;
    }

    public int changePlayer(){
        return this.activePlayer = (this.activePlayer + 1) % NUMBER_PLAYERS;
    }
}
