package Characters;

public class Lancer extends BaseNpc{
    public Lancer(int line, int column, Team allies, Team enemies) {
        super(new Coordinates(line, column),'L',4, 5,  new int[]{1,3}, 10, 4, allies, enemies);
    }

    @Override
    public void step() {

    }
}
