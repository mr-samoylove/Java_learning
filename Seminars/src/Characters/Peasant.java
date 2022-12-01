package Characters;

public class Peasant extends BaseNpc {

    public Peasant(int line, int column, Team allies, Team enemies) {
        super(new Coordinates(line, column), 'P', 1, 1, new int[]{1, 1}, 1, 3, allies, enemies);
    }

    @Override
    public void step() {
        status = "ready";
    }
}
