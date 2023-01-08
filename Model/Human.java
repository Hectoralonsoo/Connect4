package Model;

import java.util.InputMismatchException;
import java.util.Scanner;
import Console.Show;


public class Human extends Player{

    public Human(Color color) {
        super(color);
    }

    @Override
    protected int readColumn() {
    int column;
    Scanner scanner = new Scanner(System.in);
    Show.insertToken();


        do {
            try {
                column = scanner.nextInt() - 1;
            }catch(InputMismatchException ex){
                column = -1;
                scanner.nextLine();
            }
        }while(column < 0 || column > 6);
        return column;
    }
    

}
