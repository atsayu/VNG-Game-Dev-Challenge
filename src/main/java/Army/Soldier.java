package Army;

public abstract class Soldier {
    private int damage;
    private int hitpoints;

    public Soldier(int damage, int hitpoints) {
        this.damage = damage;
        this.hitpoints = hitpoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }
    public  abstract String getType();
}
