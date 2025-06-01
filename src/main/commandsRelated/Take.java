package main.commandsRelated;

import exceptions.InvalidCommandException;
import exceptions.ItemNotInLocationException;
import main.Game;
import main.itemsRelated.Puzzle;

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
            if (getGame().getWorldMap().getPlayerLocation().getItem(objectToTake) == null) {
                throw new ItemNotInLocationException(objectToTake);
            } else if (getGame().getWorldMap().getPlayerLocation().getItem(objectToTake) instanceof Puzzle) {
                System.out.println("You can't take the " + objectToTake + ".");
            } else {
                    getGame().getItemManager().moveItemToInventory(getGame().getWorldMap().getPlayerLocation().getItem(objectToTake));
            }
        } else {
            throw new InvalidCommandException();
        }
    }
}
