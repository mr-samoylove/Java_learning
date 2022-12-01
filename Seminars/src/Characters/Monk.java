package Characters;

public class Monk extends BaseNpc {
    public Monk(int line, int column, Team allies, Team enemies) {
        super(new Coordinates(line, column), 'M', 12, 7, new int[]{-4, -4}, 30, 5, allies, enemies);
    }

    @Override
    public void step() {
        // Сначала поиск тиммейта с наименьшим % хп
        BaseNpc toHeal = super.allies.getNpcWithLeastHP();

        // процесс лечения
        toHeal.setHealth(toHeal.getHealth() - this.getDamage()[1]);

        // обработка случая, если прибавка здоровья вышла за границы максимального здоровья
        if (toHeal.getHealth() > toHeal.getMaxHealth()) {
            toHeal.setHealth(toHeal.getMaxHealth());
        }
    }
}
