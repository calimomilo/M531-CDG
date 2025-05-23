package main;

import main.commandsRelated.CommandRegistry;

import java.util.Scanner;

public class Game {

    public Game(){
        System.out.println("Initializing game...");
        // TODO : code de création des éléments du jeu (instanciation de tous les objets en gros)
        WorldMap worldMap = new WorldMap();
        Location l1 = new Location("Kitchen", "There is a table in the middle of the room, and a sink and fridge against the north wall.", false);
        Location l2 = new Location("Living Room", "There are two beanbags around a carpet in the center of the room. A door leads west and the kitchen can be seen to the north.", false);
        Location l3 = new Location("Bedroom", "There is a bed in a corner and a closet near the door to the east.", false);
        Location l4 = new Location("Entrance Hall", "A hallway stretches to the north.", false);
        Location l5 = new Location("Bathroom", "There is a shower, a toilet, and a sink with a dirty mirror above it. Doors lead to the south and east.", false);
        Location l6 = new Location("South Hallway", "The hallway stretches to the north, with a door to the west.", false);
        Location l7 = new Location("North Hallway", "The hallway stretches south, with doors to the east and west.", false);

        worldMap.addLocation(l1, 2, 3);
        worldMap.addLocation(l2, 2, 2);
        worldMap.addLocation(l3, 0, 1);
        worldMap.addLocation(l4, 1, 0);
        worldMap.addLocation(l5, 0, 2);
        worldMap.addLocation(l6, 1, 1);
        worldMap.addLocation(l7, 1, 2);
    }
    
    public void run() {
        System.out.println("Running game...");
        // your runtime code here...

        CommandRegistry cr = new CommandRegistry();
        int i = 1;
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
        userInput = sc.nextLine();
        sc.close();
        return userInput;
    }

}