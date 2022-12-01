package Characters;

public class Bandit extends BaseNpc {
    public Bandit(int line, int column, Team allies, Team enemies) {
        super(new Coordinates(line, column), 'B', 8, 3, new int[]{2, 4}, 10, 6, allies, enemies);
    }

    @Override
    public void step() {

    }
}
