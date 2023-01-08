package Service;
import Model.Board;
import Console.Show;
import Console.Memento;
import Model.*;
import Model.Connect4;

import java.util.Scanner;

public class Services {

   Show show;
   Connect4 connect4;
   Goal goal;

    public Services(Connect4 connect4){
        this.show = new Show();
        this.connect4 = connect4;
        this.goal = new Goal(connect4.getBoard());
    }


    public boolean noWinnerYet(){
        boolean result = !goal.winner(connect4.getPlayer()[connect4.getTurn().getActivePlayer()]) ? true : false;
        return result;
    }

    public void resetBoard(){
        connect4.getBoard().resetBoard();
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





}
