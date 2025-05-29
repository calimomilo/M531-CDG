package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;

public class Use extends Command {
    public Use(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if (args[0].isEmpty()) {
            throw new InvalidCommandException();
        } else {
            //TODO use item here
        }
    }
}
