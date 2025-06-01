package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;
import main.itemsRelated.Item;

public class List extends Command {

    public List(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) {
        if (args[0].isEmpty()) {
            if (getGame().getPlayer().getInventory().getItems().isEmpty()) {
                System.out.println("Your inventory is empty");
            } else {
                for (Item i : getGame().getPlayer().getInventory().getItems()) {
                    System.out.println(i.getName());
                }
            }
        } else {
            throw new InvalidCommandException();
        }
    }
}
