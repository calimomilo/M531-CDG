package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;

public class Say extends Command {
    public Say(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if (args[0].isEmpty()) {
            throw new InvalidCommandException();
        } else {
            //TODO if answer is correct put key in inventory else...do what?
        }
    }
}
