package main.commandsRelated;

import main.Game;
import main.Location;

public class Move extends Command {

    public Move(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) {
        String direction = args[0];
        int x = getGame().getWorldMap().getPlayerLocationCoords()[0];
        int y = getGame().getWorldMap().getPlayerLocationCoords()[1];

        switch (direction) {
            case "north": y++; break;
            case "south": y--; break;
            case "east": x++; break;
            case "west": x--; break;
        }

        Location newLocation = getGame().getWorldMap().getLocation(x, y, getGame().getWorldMap().getAllLocations());

        if (newLocation != null) {
            if (newLocation.getIsLocked()) {
                System.out.println("Zone locked");
            } else {
                getGame().getWorldMap().setPlayerLocation(newLocation);
                getGame().getCommandRegistry().getCommands().get("look").execute(new String[]{""});
            }
        } else {
            System.out.println("Impossible to move there");
        }
    }
}
