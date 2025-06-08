package main.commandsRelated;

import exceptions.InvalidCommandException;
import exceptions.ItemNotInInventoryException;
import main.Game;
import main.Location;
import utils.Array2Dprinter;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.ArrayList;

public class Teleport extends Command {
    public Teleport(String name, String description, Game game) {
        super(name, description, game);
    }

    public void execute(String[] args) {
        if (!args[0].isEmpty()) {
            StringBuilder string = new StringBuilder();
            for (String arg : args) {
                string.append(arg).append(" ");
            }
            String moveLocation = string.toString().trim();
            boolean notFound = true;
            // first check needed to prevent the player to teleport to a placeholder location
            if (!(moveLocation.equalsIgnoreCase("locked") || moveLocation.equalsIgnoreCase("unlocked"))) {
                for (ArrayList<Location> column : getGame().getWorldMap().getDiscoveredLocations()) {
                    for (Location loc : column) {
                        if (loc != null && loc.getName().equalsIgnoreCase(moveLocation)) {
                            getGame().getWorldMap().setPlayerLocation(loc);
                            System.out.println(StringStyling.StyleString(loc.getName(), Style.BOLD, Color.DEFAULT));
                            notFound = false;
                        }
                    }
                }
            } else {
                Array2Dprinter.easterEgg();
            }
            if (notFound) {
                System.out.println("You can't teleport there.");
            }
        } else {
            throw new InvalidCommandException();
        }
    }
}
