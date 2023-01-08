package Console;

import Model.*;

public class Show implements GamePrinter {


    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";


    public static void columnCompleted(){
        System.out.println("The column is completed, please introduce another one:");
    }

    public static void insertToken(){
        System.out.println("Enter a column to drop a token [1-7]:");
    }


    public void showHelp(String message){
        System.out.println(Show.GREEN +"         - " +message+ Show.RESET);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    @Override
    public void printBoard(Board board) {
        for(int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++){
                System.out.print(" | " + board.tokens[i][j].write());
            }
            System.out.println(" |");
        }
    }

    public void printUndo(){
        System.out.println("¿Quiere hacer UNDO?(y/n)");
    }
    public void printRedo(){
        System.out.println("¿Quiere hacer REDO?(y/n)");
    }
    @Override
    public void showActivePlayer(Player player) {
        System.out.println(player.getColor() + " player turn");
    }

    @Override
    public void showWinner(Player player) {
        System.out.println(player.getColor()+ " WINSSS!!!!!");
    }
}
