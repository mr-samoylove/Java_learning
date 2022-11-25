import java.util.ArrayList;

public class Wizard extends BaseNpc {
    private ArrayList<BaseNpc> team;

    public Wizard(ArrayList<BaseNpc> team) {
        super(17, 12, 0, new int[]{-5, -5}, 30, 9, false, true);
        this.team = team;
    }

    @Override
    public void step() {
        // Сначала поиск тиммейта с наименьшим % хп
        BaseNpc toHeal = team.get(0);
        for (BaseNpc teammate : team) {
            if (teammate.getHealth() / teammate.getMaxHealth() < toHeal.getHealth() / toHeal.getMaxHealth()) {
                toHeal = teammate;
            }
        }

        // процесс лечения
        toHeal.setHealth(toHeal.getHealth() - this.getDamage()[1]);

        // обработка случая, если прибавка здоровья вышла за границы максимального здоровья
        if (toHeal.getHealth() > toHeal.getMaxHealth()) {
            toHeal.setHealth(toHeal.getMaxHealth());
        }
    }
}
