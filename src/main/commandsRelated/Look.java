package main.commandsRelated;

import main.Game;

/**
 * @param Look class extends Command class and implements the execute method.
 */

public class Look extends Command{

    public Look(String verb, String description, Game game) {
        super(verb, description, game);
    }

    @Override
    public void execute(String[] args) {
        System.out.println("You look around and see a beautiful landscape.");
    }

}
