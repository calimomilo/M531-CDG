package main;

import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
        //TODO : see if it's possible to not save new changes instead of completely rewriting the save file
    }
}
