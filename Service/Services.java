package Service;
import Model.Board;
import Console.Show;
import Model.*;
import Model.Connect4;

import java.util.Scanner;

public class Services {

   private Show show;
   private Connect4 connect4;
   private Goal goal;

    public Services(){
        this.show = new Show();
        this.connect4 = new Connect4();
        this.goal = new Goal(connect4.getBoard().copy());
    }

    public void setGoal(Board board){
        this.goal = new Goal(board);
    }


    public boolean noWinnerYet(){
        return !goal.winner(connect4.getPlayer()[connect4.getTurn().getActivePlayer()]);
    }


    public boolean isBoardEmpty(){
        return connect4.getBoard().isEmpty();
    }
    public boolean isUndo(){
        Scanner scanner = new Scanner(System.in);
        show.printUndo();
        String stringUndo = scanner.nextLine().toUpperCase();

        return stringUndo.equals("Y");

    }
    public boolean isRedo(){
        Scanner scanner = new Scanner(System.in);
        show.printRedo();
        String stringRedo = scanner.nextLine().toUpperCase();

        return stringRedo.equals("Y");
    }




    public void setBoard(Board board){
        connect4.setBoard(board);
    }

    public Board getBoard(){
        return connect4.getBoard();
    }


    public void setPlayer1(Player player){
        connect4.getPlayer()[0] = player;
    }
    public void setPlayer2(Player player){
        connect4.getPlayer()[1] = player;
    }

    public Player[] getPlayer() {
        return connect4.getPlayer();
    }

    public ITurn getTurn() {
        return connect4.getTurn();
    }

    public boolean isHumanPlayer1(){
        boolean result =connect4.getPlayer()[0].getClass() == Human.class ? true : false;
        return result;
    }
    public boolean isHumanPlayer2() {

        boolean result =connect4.getPlayer()[1].getClass() == Human.class ? true : false;
        return result;

    }

}
