package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;

public class Inspect extends Command {

    public Inspect(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if (args.length == 1) {
            String objectToInspect = args[0];
            System.out.println(getGame().getItemManager().getName());
            System.out.println(getGame().getItemManager().getDescription());
        }
    }
}
