package Model;
import java.lang.*;

public class Board{
    public Token[][] tokens;
    private static final int columns = 7;
    private static final int rows = 6;

    public Board(){
        this.tokens = new Token[rows][columns];
        this.reset();
    }


    public Board copy() {
        Board clone = new Board();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                if (this.tokens[i][j] != null)
                    clone.tokens[i][j] = this.tokens[i][j].copy();

        return clone;
    }

    public Board reset(){
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++) {
                tokens[i][j] = new Token(Color.NULL);
            }
        return this;
    }


    public int getColumns(){
        return this.columns;
    }
    public int getRows(){
        return this.rows;
    }


    public boolean isFull(){
        return !tokens[0][0].isNull() && !tokens[0][1].isNull() && !tokens[0][2].isNull() && !tokens[0][3].isNull() && !tokens[0][4].isNull() && !tokens[0][5].isNull() && !tokens[0][6].isNull();
    }
    public boolean isEmpty(){
        return tokens[5][0].isNull() && tokens[5][1].isNull() && tokens[5][2].isNull() && tokens[5][3].isNull() && tokens[5][4].isNull() && tokens[5][5].isNull() && tokens[5][6].isNull();
    }
    }



