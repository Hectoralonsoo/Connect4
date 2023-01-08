package Console;
import Model.*;
import Model.Human;
import Service.DependencyInjector;
import Service.Services;




import java.util.Scanner;

public class Command {
    private static final String INSERT_COMMAND = "INSERT COMMAND>>";
    private static final String BASIC = "BASIC";
    private static final String DEMO = "DEMO";
    private static final String TRAINING = "TRAINING";

    private static final String UNDO = "UNDO";
    private static final String REDO= "REDO";
    private static final String HELP = "HELP";

    private static  String command = "";

    private Show show;
    private Scanner sc = new Scanner(System.in);
    private Services services;


    public Command(Services services, Show show) {
        this.services = services;
        this.show = show;
    }





    private void help(){
        this.show.showHelp(Command.HELP+ " : Shows the list of available commands.");
        this.show.showHelp(Command.DEMO+ " : Game mode Machine vs Machine.");
        this.show.showHelp(Command.TRAINING+ " : Game mode Player vs Machine.");
        this.show.showHelp(Command.BASIC+ " : Classic Game Mode Player vs Player");
        this.show.showHelp(Command.UNDO+ " : Let the player to remove the last token");
        this.show.showHelp(Command.REDO+ " : Put again the removed token");
    }

    public void humanVsHuman(){
        services.setPlayer1(new Human(Color.YELLOW));
        services.setPlayer2(new Human(Color.RED));
    }

    public void machineVsMachine(){
        services.setPlayer1(new Machine(Color.YELLOW));
        services.setPlayer2(new Machine(Color.RED));
    }
    public void humanVsMachine(){
        services.setPlayer1(new Human(Color.YELLOW));
        services.setPlayer2(new Machine(Color.RED));
    }

    public void Demo(){
        machineVsMachine();
        do{

        }
    }






    public String startCommands(){
        do{
        if(services.isBoardEmpty()){
            this.show.print(this.INSERT_COMMAND);
        }

        this.command = sc.next().toUpperCase();

        switch (command) {
            case Command.HELP:

                this.help();
                break;
            case Command.BASIC:

                GameMode.BASIC.play();
                Show.print("Do you want to continue:");

                break;
            case Command.DEMO:

                GameMode.DEMO.play();
                Show.print("Do you want to continue:");

               break;
            case Command.TRAINING:

                GameMode.TRAINING.play();
                Show.print("Do you want to continue:");


                break;

            default:
                Show.print("Not a valid command, please insert a valid one>>");
                help();

        }
        this.command = sc.next().toUpperCase();
        }while(command.equals(Command.HELP) || this.command.equals("Y") || command.equals(Command.DEMO));
        return command;
    }


}