package main;

import main.commandsRelated.*;
import main.itemsRelated.*;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Game {
    private WorldMap wm = new WorldMap();
    private CommandRegistry cr = new CommandRegistry();
    private Player player = new Player("John Doe");
    private ItemManager im = new ItemManager(this);

    /**
     * Initialization of a new game, including the creation of all necessary elements
     */
    public Game(boolean loadSave){
        System.out.println(StringStyling.StyleStringBright("Initializing game...", Style.ITALIC, Color.BLACK));
        Location kitch = new Location("Kitchen", "There is a table in the middle of the room, and a sink and fridge against the north wall.", false);
        Location livr = new Location("Living Room", "There are two beanbags around a carpet in the center of the room. A door leads west and the kitchen can be seen to the north.", false);
        Location bedr = new Location("Bedroom", "There is a bed in a corner and a closet near the door to the east.", true);
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
        Command inspect = new Inspect("inspect", "Displays information about an object in the inventory", this);
        Command list = new List("list", "Displays all items from your inventory", this);
        Command take = new Take("take", "Allows the player to take an item from the location and place it in their inventory", this);
        Command say = new Say("say", "Saying the correct words to solve a puzzle will drop a key", this);
        Command use = new Use("use", "Allows the player to use an item in their inventory", this);

        Key key1 = new Key("Small Key", "A small key", bedr);
        Puzzle puzzle1 = new Puzzle("Puzzle", "A box with a seemingly voice activated lock on it", "the solution", key1, im);
        Letter letter1 = new Letter("Paper Slip", "A paper slip with the message \"The solution is the solution\" scrawled across it");
        TeleportCrystal tc = new TeleportCrystal("Teleport Crystal", "A crystal that's glowing softly. As soon as you touch it, you realize you are now able to teleport.");

        hallwn.setItems(new ArrayList<>(){{add(letter1);add(puzzle1);}});
        bedr.setItems(new ArrayList<>(){{add(tc);}});

        cr.addObserver(new CommandHistoryLogger());
        cr.setHistoryFile("command_history.txt");
        if (loadSave) {
            cr.loadAndReplayCommands(this); // Load previous history
        } else {
            // Optionally clear the history file for a new game
            try (FileWriter writer = new FileWriter("command_history.txt")) {
                writer.write(""); // Clear file
            } catch (Exception e) {
                System.out.println("Could not clear save file: " + e.getMessage());
            }
        }
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
                System.out.println(StringStyling.StyleStringBright("Exiting game...", Style.ITALIC, Color.BLACK));
                break;
            }
            cr.parseCommandInput(userInput);
        } while (true);
        // Loop runs until "exit" is entered
        String saveGameState = getUserInput(userInput + "\nDo you want to save the game state? (yes/no)");
        if (!saveGameState.equalsIgnoreCase("yes") && !saveGameState.equalsIgnoreCase("y")) {
            // We remove all the content of the history file
            try (FileWriter writer = new FileWriter("command_history.txt")) {
                writer.write(""); // Clear file
            } catch (IOException e) {
                System.out.println("Error clearing command history: " + e.getMessage());
            }
        } else{
            System.out.println("Game state saved successfully.");
            System.out.println("See ya later!");
        }
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