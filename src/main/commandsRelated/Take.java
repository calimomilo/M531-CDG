package main.commandsRelated;

import exceptions.InvalidCommandException;
import exceptions.ItemNotInLocationException;
import main.Game;

public class Take extends Command {
    public Take(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) {
        if (!args[0].isEmpty()) {
            StringBuilder string = new StringBuilder();
            for (String arg : args) {
                string.append(arg).append(" ");
            }
            String objectToTake = string.toString().trim();
            if (getGame().getWorldMap().getPlayerLocation().getItem(objectToTake) != null) {
                getGame().getItemManager().moveItemToInventory(getGame().getWorldMap().getPlayerLocation().getItem(objectToTake));
            } else {
                throw new ItemNotInLocationException(objectToTake);
            }
        } else {
            throw new InvalidCommandException();
        }
    }
}
