package Characters;

public class Wizard extends BaseNpc {
    public Wizard(int line, int column, Team allies, Team enemies) {
        super(new Coordinates(line, column), 'W', 17, 12, new int[]{-5, -5}, 30, 9, allies, enemies);
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
