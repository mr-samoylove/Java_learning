package Characters;

import java.util.Arrays;

public abstract class BaseNpc implements BaseBehaviour {
    private static int staticCounterID = 1;
    private final char typeSymbol;
    protected Team team;

    protected Coordinates coordinates;
    protected int npcID;
    protected int attack;
    protected int protection;
    protected int shots;
    protected int[] damage;
    protected double maxHealth;
    protected double health;
    protected int speed;
    protected boolean delivery;
    protected boolean magic;

    public BaseNpc(Coordinates coordinates, char typeSymbol, int attack, int protection, int shots,
                   int[] damage, double maxHealth, int speed, boolean delivery, boolean magic, Team team) {
        this.npcID = staticCounterID++;
        this.typeSymbol = typeSymbol;
        this.coordinates = coordinates;
        this.attack = attack;
        this.protection = protection;
        this.shots = shots;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;

        this.team = team;
        team.add(this);
    }

    public String getInfo() {
        return "npcID=" + npcID +
                ", type=" + this.getClass().getSimpleName() +
                ", attack=" + attack +
                ", protection=" + protection +
                ", shots=" + shots +
                ", damage=" + Arrays.toString(damage) +
                ", health=" + health +
                ", maxHealth=" + maxHealth +
                ", speed=" + speed +
                ", delivery=" + delivery +
                ", magic=" + magic;
    }

    @Override
    public String toString() {
        return this.getInfo();
    }


    //region ---Getters---

    public String getTeamColor() {
        return team.teamColor;
    }

    public char getTypeSymbol() {
        return typeSymbol;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

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

    public double getMaxHealth() {
        return maxHealth;
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


    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

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

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
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
