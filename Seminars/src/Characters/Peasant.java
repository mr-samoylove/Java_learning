package Characters;

public class Peasant extends BaseNpc {

    public Peasant(int line, int column, Team team) {
        super(new Coordinates(line, column), 'P', 1, 1, 0, new int[]{1, 1}, 1, 3, true, false, team);
    }

    @Override
    public void step() {

    }
}
