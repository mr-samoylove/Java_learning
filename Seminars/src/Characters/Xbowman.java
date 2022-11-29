package Characters;

public class Xbowman extends BaseNpc {
    public Xbowman(int line, int column, Team team) {
        super(new Coordinates(line, column), 'C', 6, 3, 16, new int[]{2, 3}, 10, 4, false, false, team);
    }

    @Override
    public void step() {

    }
}
