package items;

import player.Player;

public class Item {
    private String name;
    private String description;
    private int weight;
    private int damage;

    public Item(String name, String description, int weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }
    public Item(String name, String description,int weight , int damage) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.damage = damage;


    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public void use(Player player) {
        System.out.println("You used the " + name);
        player.setAttackPower(player.dealDamage() + damage);
        
        
    }
}
