package main.commandsRelated;

import exceptions.InvalidCommandException;
import exceptions.ItemNotInLocationException;
import main.Game;
import main.itemsRelated.Puzzle;
import main.itemsRelated.TeleportCrystal;

public class Take extends Command {
    public Take(String name, String description, Game game) {
        super(name, description, game);
    }
    /**
     * Executes the take command, which moves the specified item to the player's inventory
     * @param args the additional arguments in the input, should be the name of an item in the location for the command to work
     */
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
                if (getGame().getWorldMap().getPlayerLocation().getItem(objectToTake) instanceof TeleportCrystal) {
                    Command teleport = new Teleport("teleport", "Allows the player to move to any location they have already visited", getGame());
                }
                getGame().getItemManager().moveItemToInventory(getGame().getWorldMap().getPlayerLocation().getItem(objectToTake));
            }
        } else {
            throw new InvalidCommandException();
        }
    }
}
