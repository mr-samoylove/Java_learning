import java.util.ArrayList;

public class Priest extends BaseNpc{
    private ArrayList<BaseNpc> team;
    public Priest(ArrayList<BaseNpc> team) {
        super(12, 7, 0, new int[]{-4,-4}, 30, 5, false, true);
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
