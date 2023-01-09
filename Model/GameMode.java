package Model;


import Console.Show;
import Service.Services;


public enum GameMode implements Modes{
    BASIC,
    TRAINING,
    DEMO;


    private Show show = new Show();
    private Memento memento = new Memento();
    private Services services = new Services();


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

    public void play() {

        selectGameMode();
        show.printBoard(services.getBoard());

        do {
            memento.saveState(services.getBoard().copy());

            services.setGoal(services.getBoard());

            show.showActivePlayer(services.getPlayer()[services.getTurn().getActivePlayer()]);

            services.getPlayer()[services.getTurn().getActivePlayer()].putToken(services.getBoard());

            show.printBoard(services.getBoard());

            if(services.isHumanPlayer1() && services.getTurn().getActivePlayer() == 0){
                humanUndoRedo();
                services.setGoal(services.getBoard());
            }else if(services.isHumanPlayer2() && services.getTurn().getActivePlayer() == 1){
                humanUndoRedo();
                services.setGoal(services.getBoard());
            }

            if(services.noWinnerYet())
                services.getTurn().changePlayer();
        }while(services.noWinnerYet() && !services.getBoard().isFull());
        services.setBoard(services.getBoard().reset());
        services.setGoal(services.getBoard());
    }

    private void selectGameMode(){
        if(this == (GameMode.BASIC))
            humanVsHuman();
        else if(this == (GameMode.TRAINING) )
            humanVsMachine();
        else if(this == (GameMode.DEMO) )
            machineVsMachine();
    }


    private void humanUndoRedo(){
        if(services.isUndo()){
            services.setBoard(memento.undo(services.getBoard()));
            show.printBoard(services.getBoard());
            if(services.isRedo()){
                services.setBoard(memento.redo(services.getBoard()));
                show.printBoard(services.getBoard());
            }else{
                show.showActivePlayer(services.getPlayer()[services.getTurn().getActivePlayer()]);
                services.getPlayer()[services.getTurn().getActivePlayer()].putToken(services.getBoard());
                show.printBoard(services.getBoard());
            }
        }

    }

}
