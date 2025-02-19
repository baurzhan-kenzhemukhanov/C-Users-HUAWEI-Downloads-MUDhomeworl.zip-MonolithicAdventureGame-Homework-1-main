package managers;

import java.util.ArrayList;
import java.util.List;
import interfaces.*;
import rivals.*;
import items.*;

public class LevelManager {
    private int currentLevel;
    private List<Rival> rivals;
    private List<IItem> items;

    public LevelManager() {
        this.currentLevel = 1;
        this.rivals = new ArrayList<>();
        this.items = new ArrayList<>();
        initializeLevel();
    }

    public void initializeLevel() {
        rivals.clear();
        items.clear();

        switch (currentLevel) {
            case 1:
                rivals.add(new Orcs());
                rivals.add(new Dwarfs());
                items.add(new TitanuimSteel());
                items.add(new MiddleEastBones());
                break;
            case 2:
                rivals.add(new Elves());
                items.add(new Oakshield());
                break;
            case 3:
                rivals.add(new Elves());
                rivals.add(new Dwarfs());
                items.add(new MiddleEastBones());
                items.add(new TitanuimSteel());
                break;
        }
    }

    public boolean advanceLevel() {
        if (currentLevel < 3) {
            currentLevel++;
            initializeLevel();
            System.out.println("Advanced to level " + currentLevel);
            return true;
        }
        return false;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public List<Rival> getRivals() {
        return new ArrayList<>(rivals);
    }

    public List<IItem> getItems() {
        return new ArrayList<>(items);
    }

    public void removeRival(Rival rival) {
        rivals.remove(rival);
    }

    public void removeItem(IItem item) {
        items.remove(item);
    }

    public boolean isLevelComplete() {
        return rivals.isEmpty() && items.isEmpty();
    }
}

