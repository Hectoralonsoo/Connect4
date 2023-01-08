package Model;

public interface GamePrinter {
    void printBoard(Board board);
    void showActivePlayer(Player player);
    void showWinner(Player player);
}
