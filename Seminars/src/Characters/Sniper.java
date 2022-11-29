package Characters;

public class Sniper extends BaseNpc {
    public Sniper(int line, int column, Team team) {
        super(new Coordinates(line, column), 'S', 4, 5, 0, new int[]{1, 3}, 10, 4, false, false, team);
    }

    @Override
    public void step() {

    }
}
