package Characters;

public class Lancer extends BaseNpc{
    public Lancer(int line, int column, Team team) {
        super(new Coordinates(line, column),'L',4, 5, 0, new int[]{1,3}, 10, 4, false, false, team);
    }

    @Override
    public void step() {

    }
}
