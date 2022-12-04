package Characters.AbstractTypes;

public abstract class Shooters extends BaseNpc{

    public Shooters(Coordinates coordinates, char typeSymbol, int attack, int protection, int[] damage, double maxHealth, int speed, Team allies, Team enemies) {
        super(coordinates, typeSymbol, attack, protection, damage, maxHealth, speed, allies, enemies);
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
            shots--;
            target.takeDamage(damage);
        }
    }
}
