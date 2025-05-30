package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;
import main.Item;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class Look extends Command{

    public Look(String verb, String description, Game game) {
        super(verb, description, game);
    }

    /**
     * Executes the look command, which displays the description of the location the player is in
     * @param args the additional arguments in the input, should be empty for the command to work
     */
    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if(args[0].isEmpty()) {
            System.out.println(StringStyling.StyleString(getGame().getWorldMap().getPlayerLocation().getName(), Style.BOLD, Color.DEFAULT));
            System.out.println(getGame().getWorldMap().getPlayerLocation().getDescription());

            int itemAmount = getGame().getWorldMap().getPlayerLocation().getItems().size();

            if (itemAmount != 0) {
                StringBuilder msg = new StringBuilder("There is a ");
                for (int i = 0; i < itemAmount; i++) {
                    String name = getGame().getWorldMap().getPlayerLocation().getItems().get(i).getName();
                    msg.append(name).append(i == itemAmount - 1 ? "." : i == itemAmount - 2 ? " and a " : ", a ");
                }
                System.out.println(msg);
            }
        } else {
            throw new InvalidCommandException();
        }
    }

}
