package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;
import utils.Array2Dprinter;

public class Map extends Command {

    public Map(String name, String description, Game game) {
        super(name, description, game);
    }

    /**
     * Executes the map command, which displays the map of all discovered locations
     * @param args the additional arguments in the input, should be empty for the command to work
     */
    @Override
    public void execute(String[] args) {
        if (args[0].isEmpty()) {
            System.out.println(Array2Dprinter.print2DArray(Array2Dprinter.convert2DArray(getGame().getWorldMap()),
                    getGame().getWorldMap().getLocationCoords(getGame().getWorldMap().getPlayerLocation())[0],
                    getGame().getWorldMap().getLocationCoords(getGame().getWorldMap().getPlayerLocation())[1]));
        } else {
            throw new InvalidCommandException();
        }
    }
}
