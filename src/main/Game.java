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
    private boolean newGame;
    private boolean gameWon = false;

    /**
     * Initialization of a new game, including the creation of all necessary elements
     */
    public Game(boolean loadSave) {
        System.out.println(StringStyling.StyleStringBright((loadSave? "Loading game..." : "Initializing game..."), Style.ITALIC, Color.BLACK));

        this.newGame = !loadSave;

        Location entranceHall = new Location("Entrance Hall", "Behind you, heavy oak doors, and a sealed exit. \nTo the west, the house feels like it's pulling you in. \nYou came in this way. \nYou won’t leave by it.", false);
        Location changingRoom = new Location("Changing Room", "Tall mirrors, ornate coat racks, and a faint scent of powder and musk. \nElegant cloaks and tailored suits hang in perfect order. \nA large staircase can be seen to the west, and the front doors stand tauntingly to the east.", false);
        Location staircase = new Location("Staircase", "The walls stretch up and disappear in the darkness above. \nTo the west, a door stands ajar, and a steep staircase climbs to the north. \nTo the east, you see the changing room.", false);

        Location southHallway = new Location("South Hallway", "The polished wood floor creaks beneath your feet. \nThe stairs go down to the south and there is a hallway opposite it, lined by portraits that seem to be watching you. \nYou feel like you're being led… or herded.", false);
        Location hallway = new Location("Hallway", "The hallway stretches from south to north. \nYou can't remember how long you've been here, and you're not sure if the doors to either side of the hallway are real.", false);
        Location northHallway = new Location("North Hallway", "You stand at the north end of the hallway. \nAn unidentifiable smell makes you feel dizzy. \nYou see doors to the west and north.", false);

        Location masterBedroom = new Location("Master Bedroom", "Lavish canopy bed, gilded mirror, and the smell of perfume still lingering in the air. \nDoors lead east and north.", false);
        Location bathroom = new Location("Bathroom", "There is a message written on the mirror above the sink, but you can't seem to decipher it. \nThe sound of water dripping from the showerhead make your heart race. \nYou need to leave.", false);

        Location westDiningRoom = new Location("West Dining Room", "There is an open door to the south. \nA long polished table is set for twelve. \nYou are the only guest.", false);
        Location eastDiningRoom = new Location("East Dining Room", "There is wine in the glass at the head of the table. On the ground,\n an hourglass has fallen and spilled sand everywhere. \nThe door east leads to the kitchen.", false);
        Location kitchen = new Location("Kitchen", "Copper pots, an extinguished hearth, and butcher’s knives perfectly aligned. \nThere are doors to the west and south of the room.", false);
        Location pantry = new Location("Pantry", "Rows of spices, preserved foods, and wine. \nA strange looking bottle of Champagne lies on the floor. \nTo the north is the door to the kitchen.", true);

        Location sittingRoom = new Location("Sitting Room", "The smell of lavender is so thick you can almost taste it. \nThe fireplace is still warm... too warm. \nThere are doors to the south and east.", false);
        Location office = new Location("Office", "\nTall windows with heavy velvet drapes filter golden light onto a vast mahogany desk. \nOn the south wall, shelves of rare books and delicate instruments surround a door.", true);
        Location library = new Location("Library", "Floor-to-ceiling shelves are filled with leather-bound books. \nOne is missing its place suspiciously clean. \nThe shelf is oddly heavy—and behind it, a narrow, secret door leads east.", false);

        Location secretPassage = new Location("Secret Passage", "You can barely see through the darkness of the room, but you can feel a draft coming from the east.", false);
        Location basement = new Location("Basement", "Stone walls, cold air, and an iron gate at the far end. \nThis feels like the the way out, and something down here doesn’t want you to leave.", false);
        Location outside = new Location("Outside", "The sun blinds you as soon as you step outside. \nThe fresh air on your skin should feel like relief, but all you feel is that you've forgotten something important. \nIt's too late now. \nYou won't remember it.", true);

        wm.addLocation(entranceHall, 3, 2);
        wm.addLocation(changingRoom, 2, 2);
        wm.addLocation(staircase, 1, 2);

        wm.addLocation(southHallway, 1, 3);
        wm.addLocation(hallway, 1, 4);
        wm.addLocation(northHallway, 1, 5);

        wm.addLocation(masterBedroom, 0, 4);
        wm.addLocation(bathroom, 0, 5);

        wm.addLocation(westDiningRoom, 1, 6);
        wm.addLocation(eastDiningRoom, 2, 6);
        wm.addLocation(kitchen, 3, 6);
        wm.addLocation(pantry, 3, 5);

        wm.addLocation(sittingRoom, 0, 2);
        wm.addLocation(office, 0, 1);
        wm.addLocation(library, 0, 0);

        wm.addLocation(secretPassage, 1, 0);
        wm.addLocation(basement, 2, 0);
        wm.addLocation(outside, 3, 0);

        wm.setPlayerLocation(entranceHall);

        new Move("move", "Allows the player to move on the map", this);
        new Look("look", "Displays the description of the location of the player", this);
        new Help("help", "Displays all commands", this);
        new Map("map", "Displays the map of the locations discovered by the player", this);
        new Inspect("inspect", "Displays information about an object in the inventory", this);
        new List("list", "Displays all items from your inventory", this);
        new Take("take", "Allows the player to take an item from the location and place it in their inventory", this);
        new Say("say", "Saying the correct words to solve a puzzle will drop a key", this);
        new Use("use", "Allows the player to use an item in their inventory", this);


        Key libraryKey = new Key("Small Key", "A small key. It smells like fish.", pantry);
        Puzzle libraryPuzzle = new Puzzle("Puzzle Box", "A box with a seemingly voice activated lock on it.", "fire", libraryKey, im);
        Letter libraryLetter = new Letter("Paper Slip", "A small paper slip with the words \"I am not alive but grow. I do not breathe but need air. What am I?\" hastily scribbled on it.");

        TeleportCrystal tc = new TeleportCrystal("Crystal Pendant", "A gorgeous pendant with a crystal that's glowing softly. As soon as you touch it, you realize you are now able to teleport.");

        Key diningKey = new Key("Simple Key", "A beautiful and simple key. It looks like an office key.", office);
        Puzzle diningPuzzle = new Puzzle("Puzzle Box", "A box with a seemingly voice activated lock on it.", "sand", diningKey, im);
        Letter diningLetter = new Letter("Rolled Parchment", "A rolled parchment with the following message: \"I build castles, yet tear down mountains. I can make some men blind, and others see. What am I?\"");

        Key pantryKey = new Key("Rusty Key", "This key smells of rust and freedom.", outside);
        Puzzle pantryPuzzle = new Puzzle("Puzzle Box", "A box with a seemingly voice activated lock on it.", "gold coin", pantryKey, im);
        Letter pantryLetter = new Letter("Gold Paper", "The paper looks so bright you struggle to read it. Finally, you manage to decipher: \"I have a golden head. I have a golden tail. Yet I have no body. What am I?\"");


        library.setItems(new ArrayList<>(){{add(libraryLetter);add(libraryPuzzle);}});
        westDiningRoom.setItems(new ArrayList<>(){{add(diningLetter);add(diningPuzzle);}});
        pantry.setItems(new ArrayList<>(){{add(pantryLetter);add(pantryPuzzle);}});
        masterBedroom.setItems(new ArrayList<>(){{add(tc);}});

        cr.addObserver(new CommandHistoryLogger());
        cr.setHistoryFile("command_history.txt");
        if (loadSave) {
            getCommandRegistry().getCommands().get("look").execute(new String[]{""});
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

        if (newGame) {
            getCommandRegistry().getCommands().get("look").execute(new String[]{""});
        }

        String userInput;
        while (!gameWon) {
            userInput = getUserInput("\nWhat do you want to do?");
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("See ya later!");
                System.out.println(StringStyling.StyleStringBright("Exiting game...", Style.ITALIC, Color.BLACK));
                break;
            }
            cr.parseCommandInput(userInput);
        } // Loop runs until "exit" is entered

        if (gameWon) {
            System.out.println("\nCongratulations, you have finished the game!\nWe hope to see you again soon!");
            System.out.println(StringStyling.StyleStringBright("Exiting game...", Style.ITALIC, Color.BLACK));
        }

        String saveGameState = getUserInput("\nDo you want to save the game state? (yes/no)");
        if (!saveGameState.equalsIgnoreCase("yes") && !saveGameState.equalsIgnoreCase("y")) {
            // We remove all the content of the history file
            try (FileWriter writer = new FileWriter("command_history.txt")) {
                writer.write(""); // Clear file
            } catch (IOException e) {
                System.out.println("Error clearing command history: " + e.getMessage());
            }
        } else{
            System.out.println("Game state saved successfully.");
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

    /**
     * returns the instance of WorldMap used in the game
     * @return the instance of WorldMap used in the game
     */
    public WorldMap getWorldMap() {
        return wm;
    }

    /**
     * returns the instance of CommandRegistry used in the game
     * @return the instance of CommandRegistry used in the game
     */
    public CommandRegistry getCommandRegistry() {
        return cr;
    }

    /**
     * returns the instance of Player used in the game
     * @return the instance of Player used in the game
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * returns the instance of ItemManager used in the game
     * @return the instance of ItemManager used in the game
     */
    public ItemManager getItemManager() {
        return im;
    }

    /**
     * Defines the win status of the game, only used when the player finishes the game
     * @param gameWon the new win status of the game
     */
    public void  setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }
}