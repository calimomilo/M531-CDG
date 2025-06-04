package main;


import examples.ConsoleStylingExample;
import examples.StringManipulation;
import examples.UserInputExample;
import main.commandsRelated.Command;
import main.commandsRelated.CommandRegistry;
import main.commandsRelated.Help;
import main.itemsRelated.Item;
import main.itemsRelated.Key;
import main.itemsRelated.Letter;
import main.itemsRelated.Puzzle;
import utils.Array2Dprinter;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // you can safely remove those examples lines
//        StringManipulation.Example();
//        ConsoleStylingExample.Example();
//        UserInputExample.Example();

        /* ZONE POUR LES TESTS */
//        Map map = new Map();
//        Location l1 = new Location("Kitchen", "There is a table in the middle of the room, and a sink and fridge against the north wall.", false);
//        Location l2 = new Location("Living Room", "There are two beanbags around a carpet in the center of the room. A door leads west and the kitchen can be seen to the north.", false);
//        Location l3 = new Location("Bedroom", "There is a bed in a corner and a closet near the door to the east.", false);
//        Location l4 = new Location("Entrance Hall", "A hallway stretches to the north.", false);
//        Location l5 = new Location("Bathroom", "There is a shower, a toilet, and a sink with a dirty mirror above it. Doors lead to the south and east.", false);
//        Location l6 = new Location("South Hallway", "The hallway stretches to the north, with a door to the west.", false);
//        Location l7 = new Location("North Hallway", "The hallway stretches south, with doors to the east and west.", false);
//
//        map.addLocation(l1, 2, 3);
//        map.addLocation(l2, 2, 2);
//        map.addLocation(l3, 0, 1);
//        map.addLocation(l4, 1, 0);
//        map.addLocation(l5, 0, 2);
//        map.addLocation(l6, 1, 1);
//        map.addLocation(l7, 1, 2);
//        System.out.println(Arrays.toString(map.getLocationCoords(l2, map.getAllLocations())));
//        System.out.println(map.getAllLocations().get(0).size());
//        System.out.println(map.getAllLocations().get(1).size());
//        System.out.println(map.getAllLocations().get(2).size());
//
//        System.out.println(map.getLocationCoords(l5, map.getAllLocations())[0]);
//        System.out.println(map.getLocationCoords(l5, map.getAllLocations())[1]);
//
//        System.out.println(Array2Dprinter.print2DArray(Array2Dprinter.convert2DArray(map.getAllLocations()), map.getLocationCoords(l5, map.getAllLocations())[0], map.getLocationCoords(l5, map.getAllLocations())[1]));

//        Game testGame = new Game();
//        System.out.println(testGame.getCommandRegistry().getCommands());
//        String input = testGame.getUserInput("test2");
//        System.out.println(input);
//        testGame.getCommandRegistry().parseCommandInput(input);
//        testGame.getCommandRegistry().parseCommandInput(testGame.getUserInput("test3"));
//        System.out.println(testGame.getCommandRegistry().getCommands().containsKey("help"));
//
//        Item item1 = new Key("Key1", "A rusty key", bedr);
//        Item item3 = new Puzzle("Puzzle1", "A tricky puzzle", "Solution1", (Key) item1);
//        Item item2 = new Letter("Letter1", "A shiny letter", (Puzzle) item3);
//
//        vérifier que les items vont bien dans l'inventaire du joueur
//
//        im.moveItemToInventory(item1);
//        im.moveItemToInventory(item2);
//        im.moveItemToInventory(item3);
//
//
        /* FIN DE LA ZONE POUR LES TESTS */

        System.out.println(StringStyling.StyleStringBright("Starting...", Style.ITALIC, Color.BLACK));

        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to load the last save? (yes/no)");
        System.out.print("> ");
        String choice = sc.nextLine().trim().toLowerCase();

        Game game;
        if (choice.equals("yes") || choice.equals("y")) {
            game = new Game(true); // load save
        } else {
            game = new Game(false); // new game
        }
        game.run();

        System.out.println(StringStyling.StyleStringBright("Terminating...", Style.ITALIC, Color.BLACK));

        //TODO : maybe implement a way to ignore words like the or a in the input
        //TODO : see if we want to remove the puzzle when it's solved and the key when it's used
        //TODO : see if it's possible to not save new changes instead of completely rewriting the save file
    }
}
