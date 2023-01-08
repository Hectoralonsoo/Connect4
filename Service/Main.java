package Service;

import Console.Command;
import Console.Show;
import Model.Board;
import Model.Connect4;
import Model.GameMode;
import Service.DependencyInjector;

public class Main {
    public static void main(String[] args){
        Connect4 connect4 = new Connect4();
        Show show = new Show();
        Services services = new Services(connect4);
        Command command = new Command(services, show);
        GameMode gameMode = GameMode.valueOf(command.startCommands());
        gameMode.play();
    }
}
