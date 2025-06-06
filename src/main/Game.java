package main;

import main.commandsRelated.*;
import main.itemsRelated.*;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private WorldMap wm = new WorldMap();
    private CommandRegistry cr = new CommandRegistry();
    private Player player = new Player("John Doe");
    private ItemManager im = new ItemManager(this);

    /**
     * Initialization of a new game, including the creation of all necessary elements
     */
    public Game(){
        System.out.println(StringStyling.StyleStringBright("Initializing game...", Style.ITALIC, Color.BLACK));
        Location office = new Location("Office", "Tall windows with heavy velvet drapes filter golden light onto a vast mahogany desk. Shelves of rare books and delicate instruments surround the room", true);
        Location changingRoom = new Location("Changing room", "Tall mirrors, ornate coat racks, and a faint scent of powder and musk. Elegant cloaks and tailored suits hang in perfect order.\n" +
                "One rack is oddly heavier—and behind it, a narrow, secret door leads to the basement.", true);
        Location westBasement = new Location("West Basement", "Stone walls, cold air, iron gate at the far end. This is the way out—but it’s locked tight. And something down here doesn’t want you to leave.", true);
        Location eastBasement = new Location("East Basement", "Stone walls, cold air, iron gate at the far end. This is the way out—but it’s locked tight. And something down here doesn’t want you to leave.", true);

        Location southLibrary = new Location("South Library", "Floor-to-ceiling shelves filled with leather-bound books. One is missing its place suspiciously clean.", false);

        Location northLibrary = new Location("North Library", "Floor-to-ceiling shelves filled with leather-bound books. One is missing its place suspiciously clean.", false);
        Location Salon = new Location("Salon", "There are two beanbags around a carpet in the center of the room. A door leads west and the kitchen can be seen to the north.", false);
        Location westEntrance = new Location("West entrance", "Twin staircases, heavy oak doors, and a sealed exit. You came in this way. You won’t leave by it.", false);
        Location eastEntrance = new Location("East entrance", "Twin staircases, heavy oak doors, and a sealed exit. You came in this way. You won’t leave by it.", false);

        Location southHallway = new Location("South hallway", "Grand chandelier above, creaking wood below. Locked doors line the corridor. You feel like you're being led… or herded.", false);

        Location southMasterBedroom = new Location("South Master Bedroom", "Lavish canopy bed, gilded mirror, perfume lingering in the air. The fireplace is still warm… too warm.", false);
        Location northHallway = new Location("North Hallway", "Grand chandelier above, creaking wood below. Locked doors line the corridor. You feel like you're being led… or herded.", false);

        Location northMasterBedroom = new Location("North Master Bedroom", "Lavish canopy bed, gilded mirror, perfume lingering in the air. The fireplace is still warm… too warm.", false);
        Location southDiningRoom = new Location("South Dining Room", "Long polished table set for twelve. The chandelier above sways gently with a letter rolled around a candle. You are the only guest.", false);
        Location pantry = new Location("Pantry", "Rows of spices, preserved foods, and wine. A strange looking bottle of Champagne lays on the floor.", true);

        Location guestBedroom = new Location("Guest Bedroom", "Faint smell of lavender. A journal lies open on the nightstand—last entry unfinished. The window is locked… from the outside.", false);
        Location northDiningRoom = new Location("North Dining Room", "Long polished table set for twelve. The chandelier above sways gently with a letter rolled around a candle. You are the only guest.", false);
        Location westKitchen = new Location("West Kitchen", "Copper pots, an extinguished hearth, butcher’s knives perfectly aligned. There are recent footprints in the ash.", false);
        Location eastKitchen = new Location("East Kitchen", "Copper pots, an extinguished hearth, butcher’s knives perfectly aligned. There are recent footprints in the ash.", false);

        Location wall = new Location("Wall", "It's just a wall, nothing here...", true);


        wm.addLocation(office, 0, 0);
        wm.addLocation(changingRoom, 1, 0);
        wm.addLocation(westBasement, 2, 0);
        wm.addLocation(eastBasement, 3, 0);

        wm.addLocation(southLibrary, 0, 1);
        wm.addLocation(wall, 1, 1);
        wm.addLocation(wall, 2, 1);
        wm.addLocation(wall, 3, 1);

        wm.addLocation(northLibrary, 0, 2);
        wm.addLocation(Salon, 1, 2);
        wm.addLocation(westEntrance, 2, 2);
        wm.addLocation(eastEntrance, 3, 2);

        wm.addLocation(wall, 0, 3);
        wm.addLocation(southHallway, 1, 3);
        wm.addLocation(wall, 2, 3);
        wm.addLocation(wall, 3, 3);

        wm.addLocation(southMasterBedroom, 0, 4);
        wm.addLocation(northHallway, 1, 4);
        wm.addLocation(wall, 2, 4);
        wm.addLocation(wall, 3, 4);

        wm.addLocation(northMasterBedroom, 0, 5);
        wm.addLocation(southDiningRoom, 1, 5);
        wm.addLocation(wall, 2, 5);
        wm.addLocation(pantry, 3, 5);

        wm.addLocation(guestBedroom, 0, 6);
        wm.addLocation(northDiningRoom, 1, 6);
        wm.addLocation(westKitchen, 2, 6);
        wm.addLocation(eastKitchen, 3, 6);

        wm.addLocation(wall, 2, 0);
        wm.addLocation(wall, 2, 1);
        wm.addLocation(wall, 2, 2);
        wm.addLocation(wall, 2, 3);
        wm.addLocation(wall, 2, 4);
        wm.addLocation(wall, 2, 5);
        wm.addLocation(wall, 2, 6);

        wm.setPlayerLocation(eastEntrance);

        Command move = new Move("move", "Allows the player to move on the map", this);
        Command look = new Look("look", "Displays the description of the location of the player", this);
        Command help = new Help("help", "Displays all commands", this);
        Command map = new Map("map", "Displays the map of the locations discovered by the player", this);
        Command inspect = new Inspect("inspect", "Displays information about an object in the inventory", this);
        Command list = new List("list", "Displays all items from your inventory", this);
        Command take = new Take("take", "Allows the player to take an item from the location and place it in their inventory", this);
        Command say = new Say("say", "Saying the correct words to solve a puzzle will drop a key", this);
        Command use = new Use("use", "Allows the player to use an item in their inventory", this);


        Key libraryKey = new Key("Small Key", "A small key. It smells like fish", pantry);
        Puzzle libraryPuzzle = new Puzzle("Puzzle", "A box with a seemingly voice activated lock on it", "Sand", libraryKey, im);
        Letter libraryLetter = new Letter("Paper Slip", "I build castles, yet tear down mountains, make some men blind, and others see. What am I?");

        Key diningKey = new Key("Dining room key", "A beautiful and simple key. It looks like an office key.", office);
        Puzzle diningPuzzle = new Puzzle("Puzzle", "xxx", "A gold coin", diningKey, im);
        Letter diningLetter = new Letter("Golden riddle", "It has a golden head. It has a golden tail. It has no body.");

        Key pantryKey = new Key("Basement Key", "This key smells like freedom", eastBasement);
        Puzzle pantryPuzzle = new Puzzle("Puzzle", "xxx", "Fire", pantryKey, im);
        Letter pantryLetter = new Letter("xxx", "What is not alive but grows, does not breaths but needs air.");


        northLibrary.setItems(new ArrayList<>(){{add(libraryLetter);add(libraryKey);add(libraryPuzzle);}});
        southDiningRoom.setItems(new ArrayList<>(){{add(diningLetter);add(diningKey);add(diningPuzzle);}});
        pantry.setItems(new ArrayList<>(){{add(pantryLetter);add(pantryKey);}{add(pantryPuzzle);}});


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