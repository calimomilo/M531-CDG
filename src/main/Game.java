package main;

import exceptions.InvalidCommandException;
import main.commandsRelated.*;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game {
    private WorldMap wm = new WorldMap();
    private CommandRegistry cr = new CommandRegistry();
    private Player player = new Player();
    private ItemManager im = new ItemManager();

    /**
     * Initialization of a new game, including the creation of all necessary elements
     */
    public Game(){
        System.out.println(StringStyling.StyleStringBright("Initializing game...", Style.ITALIC, Color.BLACK));
        Location kitch = new Location("Kitchen", "There is a table in the middle of the room, and a sink and fridge against the north wall.", false);
        Location livr = new Location("Living Room", "There are two beanbags around a carpet in the center of the room. A door leads west and the kitchen can be seen to the north.", false);
        Location bedr = new Location("Bedroom", "There is a bed in a corner and a closet near the door to the east.", false);
        Location enthall = new Location("Entrance Hall", "A hallway stretches to the north.", false);
        Location bathr = new Location("Bathroom", "There is a shower, a toilet, and a sink with a dirty mirror above it. Doors lead to the south and east.", false);
        Location hallws = new Location("South Hallway", "The hallway stretches to the north, with a door to the west.", false);
        Location hallwn = new Location("North Hallway", "The hallway stretches south, with doors to the east and west.", false);

        wm.addLocation(kitch, 2, 3);
        wm.addLocation(livr, 2, 2);
        wm.addLocation(bedr, 0, 1);
        wm.addLocation(enthall, 1, 0);
        wm.addLocation(bathr, 0, 2);
        wm.addLocation(hallws, 1, 1);
        wm.addLocation(hallwn, 1, 2);

        wm.setPlayerLocation(enthall);

        Command move = new Move("move", "Allows the player to move on the map", this);
        Command look = new Look("look", "Displays the description of the location of the player", this);
        Command help = new Help("help", "Displays all commands", this);
        Command map = new Map("map", "Displays the map of the locations discovered by the player", this);

//        new Item("sharp knife", "This is a very, very sharp knife.");
//        new Item("weird clock", "The clock appears to be stuck. The time says 01:25");
//        new Item("pencil", "Just a regular pencil.");

    }

    /**
     * Runs the game
     */
    public void run() {
        System.out.println(StringStyling.StyleStringBright("Running game...\n", Style.ITALIC, Color.BLACK));
        getCommandRegistry().getCommands().get("look").execute(new String[]{""});

        String userInput;
        do {
            userInput = getUserInput("\nWhat do you want to do?");
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("See ya later!");
                System.out.println(StringStyling.StyleStringBright("Exiting game...", Style.ITALIC, Color.BLACK));
                break;
            }
            cr.parseCommandInput(userInput);
        } while (true); // Loop runs until "exit" is entered
        // end of game
    }

    /**
     * Displays the specified message and gets the following user input
     * @param message the message to display
     * @return the user's input
     */
    public String getUserInput(String message) {
        String userInput;
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        System.out.print("> ");
        userInput = sc.nextLine();
        System.out.println();
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