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
                if (newLocation.getIsLocked()) {
                    System.out.println("The door is locked. Maybe there is a key somewhere?");
                    //TODO : see if we display the locked locations => would be a problem with the isNotNew below
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
