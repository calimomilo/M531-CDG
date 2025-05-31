package main.commandsRelated;

import exceptions.InvalidCommandException;
import exceptions.UnknownItemException;
import main.Game;
import main.itemsRelated.Key;

public class Use extends Command {
    public Use(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if (args[0].isEmpty()) {
            throw new InvalidCommandException();
        } else {
            StringBuilder string = new StringBuilder();
            for (String arg : args) {
                string.append(arg).append(" ");
            }
            String objectToUse = string.toString().trim();
            if (getGame().getPlayer().getInventory().getItem(objectToUse) != null) {
                if (!(getGame().getPlayer().getInventory().getItem(objectToUse) instanceof Key)) {
                    System.out.println("You can't use this object ; it's not a key");
                } else {
                    Key key = (Key) getGame().getPlayer().getInventory().getItem(objectToUse);
                    int[] playerCoords = getGame().getWorldMap().getPlayerLocationCoords();
                    int[] coords = getGame().getWorldMap().getLocationCoords(key.getLocationLinked());

                    if ((playerCoords[0] == coords[0] && (playerCoords[1] == coords[1]+1 || playerCoords[1] == coords[1]-1))
                            || (playerCoords[1] == coords[1] && (playerCoords[0] == coords[0]+1 || playerCoords[0] == coords[0]-1))) {
                        key.unlockLocation();
                        System.out.println("The key turns in the lock. The door is open !");
                    } else {
                        System.out.println("This key doesn't fit here");
                    }
                }
            } else {
                throw new UnknownItemException(objectToUse);
            }
        }
    }
}
