package Characters;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public abstract class BaseNpc implements BaseBehaviour {
    // region ---class fields---
    private static int staticCounterID = 1;
    private char typeSymbol;
    protected Team allies;
    protected Team enemies;

    protected Coordinates coordinates;
    protected int orderPriority;
    protected int npcID;
    protected int attack;
    protected int protection;
    protected int shots;
    protected int[] damage;
    protected double maxHealth;
    protected double health;
    protected int speed;
    protected String status;
    // endregion

    // region ---class methods---
    public BaseNpc(Coordinates coordinates, char typeSymbol, int attack, int protection,
                   int[] damage, double maxHealth, int speed, Team allies, Team enemies) {
        this.npcID = staticCounterID++;
        this.typeSymbol = typeSymbol;
        this.coordinates = coordinates;
        this.attack = attack;
        this.protection = protection;
        this.shots = 0;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.speed = speed;
        this.status = "ready";

        this.allies = allies;
        allies.add(this);
        this.enemies = enemies;

        switch (typeSymbol) {
            case 'B', 'L' -> orderPriority = 1;
            case 'S', 'X' -> orderPriority = 2;
            case 'M', 'W' -> orderPriority = 3;
            case 'P' -> orderPriority = 4;
        }
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
                ", speed=" + speed;
    }

    @Override
    public String toString() {
        return this.getInfo();
    }

    public static double calculateDamage(BaseNpc attacker, BaseNpc defender) {
        int x = attacker.attack - defender.protection;
        if (x > 0) return attacker.damage[1];
        else if (x < 0) return attacker.damage[0];
        else return (double) (attacker.damage[0] + attacker.damage[1]) / 2;
    }

    public void takeDamage(double damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            status = "dead";
            typeSymbol = '_';
            allies.remove(this);
            allies = Team.THE_KILLED;
        }
    }

    // endregion




    //region ---Getters---


    public int getOrderPriority() {
        return orderPriority;
    }

    public String getTeamColor() {
        return allies.teamColor;
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

    public String getStatus() {
        return status;
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

    public void setStatus(String status) {
        this.status = status;
    }

    //endregion
}
