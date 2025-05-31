package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;
import main.itemsRelated.Item;

public class Take extends Command {
    public Take(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if (!args[0].isEmpty()) {
            for(Item i : getGame().getWorldMap().getPlayerLocation().getItems()) {
                getGame().getItemManager().moveItemToInventory(i);
            }
        } else {
            throw new InvalidCommandException();
        }
    }
}
