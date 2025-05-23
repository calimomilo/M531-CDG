package main;

import main.commandsRelated.CommandRegistry;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game {

    public Game(){
        System.out.println("Initializing game...");
        // TODO : code de création des éléments du jeu (instanciation de tous les objets en gros)
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