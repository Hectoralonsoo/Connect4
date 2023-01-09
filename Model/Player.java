package Model;

import Console.Command;
import Console.*;

import java.util.InputMismatchException;

public abstract class Player {
    private final Color color;


    private int lastColumn;
    private int lastRow;

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void putToken(Board board) {
        int column = readColumn();
        int row = 5;
        while (!board.tokens[row][column].isNull() && row >= 0) {
            if (row == 0) {
                if(this.getClass() == Human.class)
                Show.columnCompleted();
                column = readColumn();

                row = 5;
            } else
                row--;
        }
        board.tokens[row][column].setColor(this.color);
        this.lastColumn = column;
        this.lastRow = row;


    }

    protected abstract int readColumn() throws InputMismatchException;

    public int getLastColumn() {
        return lastColumn;
    }
    public int getLastRow() {
        return lastRow;
    }
}
