package Console;
import Model.Board;
import java.util.Scanner;
import java.util.Stack;

public class Memento {
    public Stack<Board> undoStack;
    public Stack<Board> redoStack;
    private Show show = new Show();

    public Memento(){
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void saveState(Board board){

        undoStack.push(board.copy());
        redoStack.clear();
    }

    public Board undo(Board actualBoard){
        Board state = null;

        if(!undoStack.empty()){
            state = undoStack.pop();
            redoStack.push(actualBoard);
        }
        return state;
    }

    public Board redo(Board actualBoard){
        Board state = null;

        if(!redoStack.empty()){
            state = redoStack.pop();
            undoStack.push(actualBoard);
        }
        return state;
    }


}
