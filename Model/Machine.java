package Model;

public class Machine extends Player{

    public Machine(Color color) {
        super(color);
    }

    @Override
    protected int readColumn() {
        return (int)Math.floor(Math.random()*7);
    }
}
