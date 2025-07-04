package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;
import main.Location;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class Move extends Command {

    public Move(String name, String description, Game game) {
        super(name, description, game);
    }
    /**
     * Executes the move command, which moves the player on the map
     * @param args the additional arguments in the input, should be a cardinal direction for the command to work
     */
    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            String direction = args[0];
            int x = getGame().getWorldMap().getPlayerLocationCoords()[0];
            int y = getGame().getWorldMap().getPlayerLocationCoords()[1];

            switch (direction) {
                case "north": y++; break;
                case "south": y--; break;
                case "east": x++; break;
                case "west": x--; break;
                default: throw new InvalidCommandException();
            }

            Location newLocation = getGame().getWorldMap().getLocation(x, y, getGame().getWorldMap().getAllLocations());

            if (newLocation != null) {
                if (newLocation.getName().equals("Outside") && !newLocation.getIsLocked()) {
                    getGame().setGameWon(true);
                }
                if (newLocation.getIsLocked()) {
                    System.out.println("The door is locked. Maybe there is a key somewhere?");
                    // adds a placeholder location to display found locked locations on the map
                    getGame().getWorldMap().addLocationToArrayList(new Location("Locked", "Placeholder locked location", true), getGame().getWorldMap().getLocationCoords(newLocation)[0], getGame().getWorldMap().getLocationCoords(newLocation)[1], getGame().getWorldMap().getDiscoveredLocations());
                } else {
                    boolean isNotNew = getGame().getWorldMap().containsLocation(newLocation, getGame().getWorldMap().getDiscoveredLocations());
                    getGame().getWorldMap().setPlayerLocation(newLocation);
                    if (isNotNew) {
                        System.out.println(StringStyling.StyleString(newLocation.getName(), Style.BOLD, Color.DEFAULT));
                    } else {
                        getGame().getCommandRegistry().getCommands().get("look").execute(new String[]{""});
                    }
                }
            } else {
                System.out.println("You can't go that way.");
            }
        } else {
            throw new InvalidCommandException();
        }
    }
}
