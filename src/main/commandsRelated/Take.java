package main.commandsRelated;

import exceptions.InvalidCommandException;
import exceptions.UnknownItemException;
import main.Game;
import main.itemsRelated.Item;

public class Take extends Command {
    public Take(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if (!args[0].isEmpty()) {
            StringBuilder string = new StringBuilder();
            for (String arg : args) {
                string.append(arg).append(" ");
            }
            String objectToInspect = string.toString().trim();
            if (getGame().getWorldMap().getPlayerLocation().getItem(objectToInspect) != null) {
                getGame().getItemManager().moveItemToInventory(getGame().getWorldMap().getPlayerLocation().getItem(objectToInspect));
            } else {
                throw new UnknownItemException(objectToInspect);
            }
        } else {
            throw new InvalidCommandException();
        }
    }
}
