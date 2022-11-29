package Characters;

public class Bandit extends BaseNpc {
    public Bandit(int line, int column, Team team) {
        super(new Coordinates(line, column), 'B', 8, 3, 0, new int[]{2, 4}, 10, 6, false, false, team);
    }

    @Override
    public void step() {

    }
}
