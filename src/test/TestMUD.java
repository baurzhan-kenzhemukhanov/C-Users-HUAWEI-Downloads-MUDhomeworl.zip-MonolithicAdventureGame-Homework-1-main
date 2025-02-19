package test;

import controller.MUDController;
import player.Player;
import locations.Room;
import items.Item; 
import rivals.Rival;
import rivals.Orcs; 

public class TestMUD {
    public static void main(String[] args) {
        Room entrance = new Room("Entrance", "A dimly lighted entrance to a cave.");
        Room hall = new Room("Hall", "A long hall with torches on the walls.");
        Room chamber = new Room("Chamber", "A wide chamber with a stone altar in the center.");
        Rival orc = new Orcs();
        Room pvpzone = new Room("PvP Zone", "A dangerous area where players and rivals can fight each other.",orc);

        entrance.setForward(hall);
        hall.setBack(entrance);
        hall.setForward(chamber);
        chamber.setBack(hall);
        chamber.setRight(chamber);
        chamber.setLeft(pvpzone);
        pvpzone.setRight(chamber);

        Item sword = new Item("Sword", "A rusty iron sword. Imroves attack power +20 ", 20,20); 
        entrance.addItem(sword);

        Item potion = new Item("Potion", "A small healing potiom.", 1);
        chamber.addItem(potion);


        Player player = new Player("Adventurer");
        player.setCurrentRoom(entrance);


        MUDController controller = new MUDController(player);
        controller.runGameLoop();
    }
}
