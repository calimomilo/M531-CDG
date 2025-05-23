package main.commandsRelated;

import main.Game;

public class Look extends Command{

    public Look(String verb, String description, Game game) {
        super(verb, description, game);
    }

    /**
     * Executes the look command, which displays the description of the location the player is in
     * @param args the additional arguments in the input, should be empty for the command to work
     */
    @Override
    public void execute(String[] args) {
        if(args[0].isEmpty()) {
            System.out.println(getGame().getWorldMap().getPlayerLocation().getDescription());
        }
    }

}
