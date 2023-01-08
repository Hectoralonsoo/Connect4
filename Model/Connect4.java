package Model;

import Console.Command;
import Console.Show;
import Service.DependencyInjector;
import Service.Services;

import java.util.InputMismatchException;


public class Connect4 {
    private Board board;
    private ITurn turn;
    private Player[] player;


    public Connect4(){
        this.board = new Board();
        this.turn = new Turn(board);
        this.player = new Player[2];
    }

    public void setBoard(Board board){
        this.board = board;
    }
    public void setPlayer1(Player player){
        this.player[0] = player;
    }
    public void setPlayer2(Player player){
        this.player[1] = player;
    }
    public Board getBoard(){
        return this.board;
    }

    public Player[] getPlayer() {
        return player;
    }
    public boolean isHumanPlayer1(){
        boolean result =player[1].getClass() == Human.class ? true : false;
        return result;
    }
    public boolean isHumanPlayer2() {

        boolean result =player[1].getClass() == Human.class ? true : false;
        return result;

    }
    public ITurn getTurn() {
        return turn;
    }
}