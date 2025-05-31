package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;

public class Inspect extends Command {

    public Inspect(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if (!args[0].isEmpty()) {
            String objectToInspect = args[0];
            System.out.println(getGame().getItemManager().getInventory().getItem(objectToInspect).getName());
            System.out.println(getGame().getItemManager().getInventory().getItem(objectToInspect).getDescription());
        } else {
            throw new InvalidCommandException();
        }
    }
}
