package controller;

import player.Player;
import rivals.Rival;
import locations.Room;
import items.Item;

import java.util.Scanner;

public class MUDController {
    private Player player;
    private boolean running;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }
    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the MUD! Type 'help' to see commands.");

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            handleInput(input);
        }

        System.out.println("Goodbye!");
    }

    private void handleInput(String input) {
        if (input.isEmpty()) {
            System.out.println("No command entered.");
            return;
        }

        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = (parts.length > 1) ? parts[1].toLowerCase() : "";

        switch (command) {
            case "look":
                lookAround();
                break;

            case "move":

                if (argument.isEmpty()) {
                    System.out.println("Usage: move <forward|back|left|right>");
                } else {
                    move(argument);
                }
                break;

            case "pick":
                if (argument.startsWith("up")) {
                    String itemName = argument.substring(2).trim();
                    pickUp(itemName);
                } else {
                    System.out.println("Usage: pick up <itemName>");
                }
                break;

            case "inventory":
                checkInventory();
                break;
            case "stats":
                checkXP();
                System.out.println("Your health is: " + player.getHealth());
                System.out.println("Your damage is: " + player.getAttackPower());
                break;
            case "use":
                if(argument.isEmpty()){
                    System.out.println("Usage: use <item>");
                }

                else{
                    if(player.getInventory().isEmpty()){
                        System.out.println("You have no items to use.");
                    }
                    else{
                        System.out.println(argument);
                        if(argument.equals("sword")){
                            player.getInventory().get(0).use(player);
                            System.out.println("Your damage is now:  " + player.dealDamage());
                        }
                        else{
                            System.out.println("You do not have that item.");
                        }
                    }
                }
                break;

            case "help":
                showHelp();
                break;
            case "fight":
                if(player.getCurrentRoom().isThereRival()){
                    

                    Rival rival = player.getCurrentRoom().getMobs().get(0);
                    System.out.println("You are fighting a " + rival.getName() + "!");
                    System.out.println("You have " + player.getHealth() + " health.");
                    System.out.println("The " + rival.getName() + " has " + rival.getHealth() + " health.");
                    while(player.getHealth() > 0 && rival.getHealth() > 0){
                        player.attack(player.getCurrentRoom().getMobs().get(0));
                        player.setHealth(player.getHealth() - player.getCurrentRoom().getMobs().get(0).dealDamage());
                        System.out.println("You have " + player.getHealth() + " health.");
                        System.out.println("The " + rival.getName() + " has " + rival.getHealth() + " health.");

                    }
                    if(player.getHealth() <= 0){
                        System.out.println("You have died RIP.");


                        running = false;
                    }
                    else{
                        System.out.println("You have defeated the " + rival.getName() + "!");
                        player.getCurrentRoom().getMobs().remove(0);
                        player.setExperience(player.getExperience() + rival.getExperience());
                        System.out.println(player.getName() + " earned " + rival.getExperience() + " XP!");
                    }
                }
                else{
                    System.out.println("There is no rival to fight here.");
                }
                break;

            case "quit":
            case "exit":
                running = false;
                break;

            default:
                System.out.println("Unknown command.");
                break;
        }
    }

    private void lookAround() {
        if (player.getCurrentRoom() == null) {
            System.out.println("You are nowhere! (No current room assigned.)");
            return;
        }
        if(player.getCurrentRoom().isThereRival()){
            System.out.println( " You see a " + player.getCurrentRoom().getMobs().get(0).getName() + " here.");
        }
        


        System.out.println(player.getCurrentRoom().describe());
    }


    private void move(String direction) {
        if (player.getCurrentRoom() == null) {
            System.out.println("No current room to move from.");
            return;
        }

        switch (direction) {
            case "forward":
                if (player.getCurrentRoom().getForward() != null) {
                    player.setCurrentRoom(player.getCurrentRoom().getForward());
                    lookAround();
                } else {
                    System.out.println("You can't go that way!");
                }
                break;
            case "back":
                if (player.getCurrentRoom().getBack() != null) {
                    player.setCurrentRoom(player.getCurrentRoom().getBack());
                    lookAround();
                } else {
                    System.out.println("You can't go that way!");
                }
                break;
            case "left":
                if (player.getCurrentRoom().getLeft() != null) {
                    player.setCurrentRoom(player.getCurrentRoom().getLeft());
                    lookAround();
                } else {
                    System.out.println("You can't go that way!");
                }
                break;
            case "right":
                if (player.getCurrentRoom().getRight() != null) {
                    player.setCurrentRoom(player.getCurrentRoom().getRight());
                    lookAround();
                } else {
                    System.out.println("You can't go that way!");
                }
                break;
            default:
                System.out.println("Usage: move <forward|back|left|right>");
                break;
        }
    }

    private void pickUp(String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Pick up what?");
            return;
        }

        if (player.getCurrentRoom() == null) {
            System.out.println("You are in no room to pick up items.");
            return;
        }


        Room room = player.getCurrentRoom();
        Item foundItem = null;
        for (Item i : room.getItems()) {
            if (i.getName().equalsIgnoreCase(itemName)) {
                foundItem = i;
                break;
            }
        }

        if (foundItem == null) {
            System.out.println("No item named " + itemName + " here!");
        } else {

            room.removeItem(foundItem);
            player.addItemToInventory(foundItem);
            System.out.println("You picked up " + foundItem.getName() + "!");
        }
    }

    private void checkInventory() {
        if (player.getInventory().isEmpty()) {
            System.out.println("You have no items.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : player.getInventory()) {
                System.out.println("- " + item.getName());
            }
        }
    }


    private void showHelp() {
        System.out.println("Commands:");
        System.out.println("  look                  - Look around your current location");
        System.out.println("  move <direction>      - Move in a direction (forward, back, left, right)");
        System.out.println("  pick up <itemName>    - Pick up an item by name");
        System.out.println("  inventory             - Check what you're carrying");
        System.out.println("  help                  - Show this help message");
        System.out.println("  quit or exit          - Quit the game");
        System.out.println("  stats                 - Check your stats");
        System.out.println("  use <item>            - Use an item");
        System.out.println("  fight                 - Fight a rival in the room!");
    }
    private void checkXP(){
        System.out.println("You have " + player.getExperience() + " XP.");

    }
}
