package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;

public class List extends Command {

    public List(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if (args[0].isEmpty()) {
            System.out.println(getGame().getItemManager().getInventory());
        } else {
            throw new InvalidCommandException();
        }
    }
}
