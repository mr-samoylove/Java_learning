package Characters.AbstractTypes;

import Map.MapMatrix;

public abstract class Warriors extends BaseNpc {
    public Warriors(Coordinates coordinates, char typeSymbol, int attack, int protection, int[] damage, double maxHealth, int speed, Team allies, Team enemies, int amount) {
        super(coordinates, typeSymbol, attack, protection, damage, maxHealth, speed, allies, enemies, amount);
    }

    @Override
    public void step() {
        BaseNpc target = enemies.getClosest(this.coordinates);
        if (target != null) {
            if (target.coordinates.isClose(this.coordinates)) {
                target.takeDamage(calculateDamage(this, target), this);
            } else {
                if (target.coordinates.y - this.coordinates.y != 0) {
                    if (target.coordinates.y > this.coordinates.y && MapMatrix.isFree(this.coordinates.x, this.coordinates.y + 1)) {
                        MapMatrix.movePlayer(this, "right");
                        return;
                    } else if (target.coordinates.y < this.coordinates.y && MapMatrix.isFree(this.coordinates.x, this.coordinates.y - 1)) {
                        MapMatrix.movePlayer(this, "left");
                        return;
                    }
                }
                if (target.coordinates.x - this.coordinates.x != 0) {
                    if (target.coordinates.x > this.coordinates.x && MapMatrix.isFree(this.coordinates.x + 1, this.coordinates.y))
                        MapMatrix.movePlayer(this, "down");
                    else if (target.coordinates.y < this.coordinates.y && MapMatrix.isFree(this.coordinates.x - 1, this.coordinates.y))
                        MapMatrix.movePlayer(this, "up");
                }
            }
        }
    }
}
