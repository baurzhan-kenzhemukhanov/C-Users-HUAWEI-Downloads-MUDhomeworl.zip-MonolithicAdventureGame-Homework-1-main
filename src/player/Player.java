package player;

import interfaces.*;
import items.Item;
import locations.Room;

import java.util.LinkedList;
import java.util.List;

public class Player implements ICombatant {
    private final String name;
    private int health;
    private int experience;
    private Room location; 
    private int attackPower = 20;
    private final List<IItem> inventory;
    private final List<Item> items;


    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        this.inventory = new LinkedList<>();
        this.items = new LinkedList<>();
        attackPower = dealDamage();
    }

    public void setCurrentRoom(Room location) {
        this.location = location;
    }
    public int attack(ICombatant target) {
        int damage = dealDamage();
        target.takeDamage(damage);
        return damage;
    }
    

    public String getLocation() {
        return location.getName();
    }

    public Room getCurrentRoom() {
        return location;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IEntityType.EntityType getType() {
        return IEntityType.EntityType.PLAYER;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int newHealth) {
        health = Math.max(0, Math.min(100, newHealth));
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public void setExperience(int xp) {
        experience = xp;
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(health - damage);
    }

    @Override
    public int dealDamage() {
        return attackPower + experience / 10;
    }

    public void addItemToInventory(IItem item) {
        if (item != null) {
            inventory.add(item);
        }
    }

    public List<IItem> retrieveInventory() {
        return new LinkedList<>(inventory);
    }

    public boolean isStillAlive() {
        return health > 0;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    public int getAttackPower() {
        return attackPower;
    }


    public void addItemToInventory(Item foundItem) {
        if (foundItem != null) {
            items.add(foundItem);
        }
    }

    public List<Item> getInventory() {
        return new LinkedList<>(items);
    }
}
