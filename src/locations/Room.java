package locations;

import java.util.ArrayList;
import java.util.List;
import interfaces.IItem;
import items.Item;
import rivals.Rival;

public class Room {
    private String name;
    private String description;
    
    private Room forward;
    private Room back;
    private Room left;
    private Room right;
    private List<Rival> mobs;

    private List<Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.mobs = new ArrayList<>(); 
    }

    public Room(String name, String description, Rival mob) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.mobs = new ArrayList<>();
        mobs.add(mob);
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getForward() {
        return forward;
    }

    public void setForward(Room forward) {
        this.forward = forward;
    }

    public Room getBack() {
        return back;
    }

    public void setBack(Room back) {
        this.back = back;
    }

    public Room getLeft() {
        return left;
    }

    public void setLeft(Room left) {
        this.left = left;
    }

    public Room getRight() {
        return right;
    }

    public void setRight(Room right) {
        this.right = right;
    }

    public List<Item> getItems() {
        return items;
    }
    public List<Rival> getMobs() {
        return mobs;
    }


    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public boolean isThereRival() {
        return !mobs.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addRival(Rival mob) {
        mobs.add(mob);
    }


    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append("You are in ").append(name).append(". ").append(description).append("\n");

        if (!items.isEmpty()) {
            sb.append("You see the following items on the ground:\n");
            for (Item i : items) {
                sb.append("- ").append(i.getName()).append("\n");
            }
        } else {
            sb.append("There are no items here.\n");
        }

        sb.append("Exits: ");
        if (forward != null) sb.append("[forward] ");
        if (back != null) sb.append("[back] ");
        if (left != null) sb.append("[left] ");
        if (right != null) sb.append("[right] ");
        sb.append("\n");

        return sb.toString();
    }
}
