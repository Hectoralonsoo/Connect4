package Service;

import Console.Command;
import Console.Show;
import Model.Connect4;
import Model.GameMode;

public class Main {
    public static void main(String[] args){

        Show show = new Show();
        Services services = new Services();
        Command command = new Command(services, show);
        try{
            GameMode gameMode = GameMode.valueOf(command.startCommands());
            gameMode.play();
        }catch (IllegalArgumentException ex){
            System.out.println("SEE YOU SOON!");
        }



    }
}
