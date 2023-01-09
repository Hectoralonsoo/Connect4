package Model;


public class Connect4 {
    private Board board;
    private ITurn turn;
    private Player[] player;


    public Connect4() {
        this.board = new Board();
        this.turn = new Turn();
        this.player = new Player[2];
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return this.board;
    }



    public Player[] getPlayer() {
        return player;
    }

    public ITurn getTurn() {
        return turn;
    }
}