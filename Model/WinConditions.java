package Model;

public interface WinConditions {
    boolean vertical(Player player);
    boolean horizontal(Player player);
    boolean diagonal(Player player);
    boolean inverseDiagonal(Player player);
}
