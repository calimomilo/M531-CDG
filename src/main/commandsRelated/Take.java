package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;

public class Take extends Command {
    public Take(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if (args[0].isEmpty()) {
            throw new InvalidCommandException();
        } else {
            //TODO put item in inventory
        }
    }
}
