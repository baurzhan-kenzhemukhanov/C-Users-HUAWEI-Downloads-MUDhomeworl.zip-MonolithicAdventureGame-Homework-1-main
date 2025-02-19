package rivals;

import interfaces.*;

public abstract class Rival implements ICombatant {
    private String nameTag;
    private int hp;
    private int xp;
    private int attackPower;

    protected Rival(String nameTag, int hp, int xp, int attackPower) {
        this.nameTag = nameTag;
        this.hp = hp;
        this.xp = xp;
        this.attackPower = attackPower;
    }

    @Override
    public String getName() {
        return nameTag;
    }

    @Override
    public IEntityType.EntityType getType() {
        return IEntityType.EntityType.RIVAL;
    }

    @Override
    public int getHealth() {
        return hp;
    }

    @Override
    public void setHealth(int newHp) {
        hp = Math.max(0, newHp);
    }

    @Override
    public int getExperience() {
        return xp;
    }

    @Override
    public void setExperience(int newXp) {
        xp = newXp;
    }

    @Override
    public void takeDamage(int damageValue) {
        setHealth(hp - damageValue);
    }

    @Override
    public int dealDamage() {
        return attackPower;
    }

    public boolean hasFallen() {
        return hp <= 0;
    }
    // @Override
    public Boolean isStillAlive(){
        return hp>0;
    }
}
