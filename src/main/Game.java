package main;

import main.commandsRelated.Command;
import main.commandsRelated.CommandRegistry;
import main.commandsRelated.Help;
import main.commandsRelated.Move;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game {
    private WorldMap wm = new WorldMap();
    private CommandRegistry cr = new CommandRegistry();
    private Player player = new Player();
    private ItemManager im = new ItemManager();

    public Game(){
        System.out.println("Initializing game...");
        // TODO : code de création des éléments du jeu (instanciation de tous les objets en gros)
        Location l1 = new Location("Kitchen", "There is a table in the middle of the room, and a sink and fridge against the north wall.", false);
        Location l2 = new Location("Living Room", "There are two beanbags around a carpet in the center of the room. A door leads west and the kitchen can be seen to the north.", false);
        Location l3 = new Location("Bedroom", "There is a bed in a corner and a closet near the door to the east.", false);
        Location l4 = new Location("Entrance Hall", "A hallway stretches to the north.", false);
        Location l5 = new Location("Bathroom", "There is a shower, a toilet, and a sink with a dirty mirror above it. Doors lead to the south and east.", false);
        Location l6 = new Location("South Hallway", "The hallway stretches to the north, with a door to the west.", false);
        Location l7 = new Location("North Hallway", "The hallway stretches south, with doors to the east and west.", false);

        wm.addLocation(l1, 2, 3);
        wm.addLocation(l2, 2, 2);
        wm.addLocation(l3, 0, 1);
        wm.addLocation(l4, 1, 0);
        wm.addLocation(l5, 0, 2);
        wm.addLocation(l6, 1, 1);
        wm.addLocation(l7, 1, 2);

        Command move = new Move("move", "Allows the player to move on the map", this);
        Command help = new Help("help", "Displays all commands", this);

        cr.addCommand(move);
    }
    
    public void run() {
        System.out.println("Running game...");
        // your runtime code here...

        CommandRegistry cr = new CommandRegistry();
        int i = 1;
        System.out.println(getUserInput(""));
        do {
            cr.parseCommandInput(getUserInput("What do you want to do?"));
            i++;
        } while (i < 3); //CHANGE THIS CONDITION !!!

        // end of game
    }

    public String getUserInput(String message) {
        String userInput;
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        userInput = sc.nextLine(); // TODO : le scanner fait buguer le truc quand on essaie de lancer le programme, trouver ce qui ne va pas
        sc.close();
        return userInput;
    }

    public WorldMap getWorldMap() {
        return wm;
    }

    public CommandRegistry getCommandRegistry() {
        return cr;
    }

    public Player getPlayer() {
        return player;
    }

    public ItemManager getItemManager() {
        return im;
    }
}