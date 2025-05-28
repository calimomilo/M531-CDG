package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;
import main.Location;

import java.util.Arrays;

public class Move extends Command {

    public Move(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) throws InvalidCommandException {
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
                    System.out.println("Zone locked");
                } else {
                    getGame().getWorldMap().setPlayerLocation(newLocation);
                    getGame().getCommandRegistry().getCommands().get("look").execute(new String[]{""});
                    // TODO : si déplacement dans une zone déjà visitée, n'afficher que le nom
                }
            } else {
                System.out.println("Impossible to move there");
            }
        } else {
            throw new InvalidCommandException();
        }
    }
}
