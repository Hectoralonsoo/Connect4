package Model;

import Console.Show;

public class Goal implements WinConditions{
    private final Board board;
    private boolean winCondition;
    Show show = new Show();


    public Goal(Board board) {
        this.board = board;
        winCondition = false;
    }



    public boolean vertical(Player player) {

        int counter = player.getLastRow();
        if (counter < 3) {

            while (board.tokens[counter][player.getLastColumn()].getColor() == player.getColor() && (counter != (player.getLastRow() + 3)))
                counter += 1;

            if (counter == (player.getLastRow() + 3) && board.tokens[counter][player.getLastColumn()].getColor() == player.getColor()) {

                show.showWinner(player);
                winCondition = true;
            }
        }
        return winCondition;
    }
        public boolean horizontal (Player player){
            int actualCol = player.getLastColumn();
            int counter = 0;

            while (actualCol < 6 && board.tokens[player.getLastRow()][actualCol + 1].getColor() == player.getColor() && counter != 3) {
                actualCol++;
                counter++;
            }
            actualCol = player.getLastColumn();

            while (actualCol > 0 && board.tokens[player.getLastRow()][actualCol - 1].getColor() == player.getColor() && counter != 3) {
                actualCol--;
                counter++;
            }

            if (counter == 3) {
                show.showWinner(player);
                winCondition = true;
            }

            return winCondition;
        }

    /**
     *
     * @param player player
     * @return return boolean
     */
        public boolean diagonal (Player player){
            int actualRow = player.getLastRow();
            int actualCol = player.getLastColumn();
            int counter = 0;

            while (actualRow > 0 && actualCol < 6 && board.tokens[actualRow - 1][actualCol + 1].getColor() == player.getColor() && counter != 3) {
                counter++;
                actualRow--;
                actualCol++;
            }

            actualCol = player.getLastColumn();
            actualRow = player.getLastRow();

            while (actualRow < 5 && actualCol > 0 && board.tokens[actualRow + 1][actualCol - 1].getColor() == player.getColor() && counter != 3) {
                counter++;
                actualRow++;
                actualCol--;
            }

            if (counter == 3) {
                show.showWinner(player);
                winCondition  = true;

            }

            return winCondition;
        }

  
    public boolean inverseDiagonal (Player player){
            int actualRow = player.getLastRow();
            int actualCol = player.getLastColumn();
            int counter = 0;

            while (actualRow < 5 && actualCol < 6 && board.tokens[actualRow + 1][actualCol + 1].getColor() == player.getColor() && counter != 3) {
                counter++;
                actualRow++;
                actualCol++;
            }

            actualCol = player.getLastColumn();
            actualRow = player.getLastRow();
            

            while (actualRow > 0 && actualCol > 0 && board.tokens[actualRow - 1][actualCol - 1].getColor() == player.getColor() && counter != 3) {
                counter++;
                actualRow--;
                actualCol--;
            }

            if (counter == 3) {
                show.showWinner(player);
                winCondition  = true;
            }
            return winCondition;
        }


        public boolean winner(Player player){
            return inverseDiagonal(player) || diagonal(player) || vertical(player) || horizontal(player);
        }
    }




