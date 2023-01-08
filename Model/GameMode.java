package Model;


import Console.Memento;
import Console.Show;
import Service.Services;


public enum GameMode implements Modes{
    BASIC,
    TRAINING,
    DEMO;


    private Connect4 connect4;


    Show show = new Show();
    Goal goal = new Goal(connect4.getBoard());
    Memento memento = new Memento();
    Services services = new Services(connect4);




    public void humanVsHuman(){
        connect4.setPlayer1(new Human(Color.YELLOW));
        connect4.setPlayer2(new Human(Color.RED));
    }

    public void machineVsMachine(){
        connect4.setPlayer1(new Machine(Color.YELLOW));
        connect4.setPlayer2(new Machine(Color.RED));
    }
    public void humanVsMachine(){
        connect4.setPlayer1(new Human(Color.YELLOW));
        connect4.setPlayer2(new Machine(Color.RED));
    }

    public void play() {

        selectGameMode();
        show.printBoard(connect4.getBoard());

        do {


            memento.saveState(connect4.getBoard().copy());

            show.showActivePlayer(connect4.getPlayer()[connect4.getTurn().getActivePlayer()]);

            connect4.getPlayer()[connect4.getTurn().getActivePlayer()].putToken(connect4.getBoard());

            show.printBoard(connect4.getBoard());

            if(connect4.isHumanPlayer1() && connect4.getTurn().getActivePlayer() == 0){
                humanUndoRedo();
            }else if(connect4.isHumanPlayer2() && connect4.getTurn().getActivePlayer() == 1){
                humanUndoRedo();
            }




            if(services.noWinnerYet())
                connect4.getTurn().changePlayer();
        }while(services.noWinnerYet()&& !connect4.getBoard().isFull());
        connect4.getBoard().reset();

    }

    public void selectGameMode(){
        if(this == (GameMode.BASIC))
            humanVsHuman();
        else if(this == (GameMode.TRAINING) )
            humanVsMachine();
        else if(this == (GameMode.DEMO) )
            machineVsMachine();
    }


    public void humanUndoRedo(){
        if(services.isUndo()){
            connect4.setBoard(memento.undo(connect4.getBoard()));
            show.printBoard(connect4.getBoard());
            if(services.isRedo()){
                connect4.setBoard(memento.redo(connect4.getBoard()));
                show.printBoard(connect4.getBoard());
            }else{
                show.showActivePlayer(connect4.getPlayer()[connect4.getTurn().getActivePlayer()]);
                connect4.getPlayer()[connect4.getTurn().getActivePlayer()].putToken(connect4.getBoard());
                show.printBoard(connect4.getBoard());
            }
        }

    }

}
