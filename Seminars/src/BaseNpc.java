import java.util.ArrayList;
import java.util.Arrays;

public abstract class BaseNpc {
    private static int staticCounterID = 1;

    protected int npcID;
    protected int attack;
    protected int protection;
    protected int shots;
    protected int[] damage;
    protected double health;
    protected int speed;
    protected boolean delivery;
    protected boolean magic;

    public BaseNpc(int attack, int protection, int shots, int[] damage, double health, int speed, boolean delivery, boolean magic) {
        this.npcID = staticCounterID++;
        this.attack = attack;
        this.protection = protection;
        this.shots = shots;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
    }

    @Override
    public String toString() {
        return  "npcID=" + npcID +
                ", type=" + this.getClass().getName() +
                ", attack=" + attack +
                ", protection=" + protection +
                ", shots=" + shots +
                ", damage=" + Arrays.toString(damage) +
                ", health=" + health +
                ", speed=" + speed +
                ", delivery=" + delivery +
                ", magic=" + magic;
    }


    /**
     * @param list список из персонажей
     * @param typename название типа в виде String, например "Archer" или "Bandit"
     */
    public static void printAllOfSpecificType(ArrayList<BaseNpc> list, String typename){
        for (BaseNpc npc : list) {
            if (npc.getClass().getName().equals(typename)) {
                System.out.println(npc);
            }
        }
    }

    //region ---Getters---
    public int getNpcID() {
        return npcID;
    }

    public int getAttack() {
        return attack;
    }

    public int getProtection() {
        return protection;
    }

    public int getShots() {
        return shots;
    }

    public int[] getDamage() {
        return damage;
    }

    public double getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public boolean isMagic() {
        return magic;
    }
    //endregion

    //region ---Setters---
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public void setDamage(int[] damage) {
        this.damage = damage;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }
    //endregion
}
