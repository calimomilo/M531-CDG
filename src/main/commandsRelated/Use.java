package main.commandsRelated;

import exceptions.InvalidCommandException;
import exceptions.ItemNotInInventoryException;
import main.Game;
import main.Location;
import main.itemsRelated.Key;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class Use extends Command {
    public Use(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) {
        if (args[0].isEmpty()) {
            throw new InvalidCommandException();
        } else {
            StringBuilder string = new StringBuilder();
            for (String arg : args) {
                string.append(arg).append(" ");
            }
            String objectToUse = string.toString().trim();
            if (getGame().getPlayer().getInventory().getItem(objectToUse) != null) {
                if (!(getGame().getPlayer().getInventory().getItem(objectToUse) instanceof Key key)) {
                    System.out.println("You can't use this object");
                } else {
                    int[] playerCoords = getGame().getWorldMap().getPlayerLocationCoords();
                    int[] coords = getGame().getWorldMap().getLocationCoords(key.getLocationLinked());

                    if ((playerCoords[0] == coords[0] && (playerCoords[1] == coords[1]+1 || playerCoords[1] == coords[1]-1))
                            || (playerCoords[1] == coords[1] && (playerCoords[0] == coords[0]+1 || playerCoords[0] == coords[0]-1))) {
                        key.unlockLocation();
                        System.out.println("The key turns in the lock. The door is open !");
                        // changes the display of a known locked location on the map to unlocked
                        if (getGame().getWorldMap().getLocation(coords[0], coords[1], getGame().getWorldMap().getDiscoveredLocations()) != null) {
                            getGame().getWorldMap().addLocationToArrayList(new Location("Unlocked", "Placeholder unlocked undiscovered location", true), coords[0], coords[1], getGame().getWorldMap().getDiscoveredLocations());
                        }
                    } else {
                        System.out.println("This key doesn't fit here");
                    }
                }
            } else {
                throw new ItemNotInInventoryException(objectToUse);
            }
        }
    }
}
