package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;
import main.itemsRelated.Item;
import main.itemsRelated.Puzzle;

public class Say extends Command {
    public Say(String name, String description, Game game) {
        super(name, description, game);
    }

    @Override
    public void execute(String[] args) throws InvalidCommandException {
        if (args[0].isEmpty()) {
            throw new InvalidCommandException();
        } else {
            StringBuilder string = new StringBuilder();
            for (String arg : args) {
                string.append(arg).append(" ");
            }
            String attempt = string.toString().trim();
            Puzzle puzzle = null;
            for (Item item : getGame().getWorldMap().getPlayerLocation().getItems()) {
                if (item instanceof Puzzle) {
                    puzzle = (Puzzle) item;
                }
            }

            if (puzzle == null) {
                System.out.println("There is no puzzle here !");
            } else if (!puzzle.solve(attempt)) {
                System.out.println("Nothing happens...");
            }
        }
    }
}
