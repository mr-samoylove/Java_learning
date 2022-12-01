package Characters;

public class Xbowman extends BaseNpc {
    public Xbowman(int line, int column, Team allies, Team enemies) {
        super(new Coordinates(line, column), 'X', 6, 3, new int[]{2, 3}, 10, 4, allies, enemies);
        this.shots = 16;
    }

    @Override
    public void step() {
        BaseNpc peasant = allies.getReadyPeasant();
        if (peasant != null) {
            shots++;
            peasant.status = "used";
        }
        if (shots > 0) {
            BaseNpc target = enemies.getClosest(this.coordinates);
            double damage = BaseNpc.calculateDamage(this, target);
            if (this.speed < Coordinates.getDistance(this.coordinates, target.coordinates)) damage /= 2;
            target.takeDamage(damage);
        }
    }
}
