package main.commandsRelated;

import exceptions.InvalidCommandException;
import exceptions.ItemNotInInventoryException;
import main.Game;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class Inspect extends Command {

    public Inspect(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) {
        if (!args[0].isEmpty()) {
            StringBuilder string = new StringBuilder();
            for (String arg : args) {
                string.append(arg).append(" ");
            }
            String objectToInspect = string.toString().trim();
            if (getGame().getPlayer().getInventory().getItem(objectToInspect) != null) {
                System.out.println(StringStyling.StyleString(getGame().getPlayer().getInventory().getItem(objectToInspect).getName(), Style.BOLD, Color.DEFAULT));
                System.out.println(getGame().getPlayer().getInventory().getItem(objectToInspect).getDescription());
            } else {
                throw new ItemNotInInventoryException(objectToInspect);
            }
        } else {
            throw new InvalidCommandException();
        }
    }
}
