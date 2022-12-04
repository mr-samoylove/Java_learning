package Characters.AbstractTypes;

public abstract class Healers extends BaseNpc {
    public Healers(Coordinates coordinates, char typeSymbol, int attack, int protection, int[] damage, double maxHealth, int speed, Team allies, Team enemies) {
        super(coordinates, typeSymbol, attack, protection, damage, maxHealth, speed, allies, enemies);
    }

    @Override
    public void step() {
        // Сначала поиск тиммейта с наименьшим % хп
        BaseNpc toHeal = allies.getNpcWithLeastHP();

        // процесс лечения
        toHeal.setHealth(toHeal.getHealth() - this.getDamage()[1]);

        // обработка случая, если прибавка здоровья вышла за границы максимального здоровья
        if (toHeal.getHealth() > toHeal.getMaxHealth()) {
            toHeal.setHealth(toHeal.getMaxHealth());
        }
    }
}
