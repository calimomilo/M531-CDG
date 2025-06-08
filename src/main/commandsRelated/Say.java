package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;
import main.itemsRelated.Item;
import main.itemsRelated.Puzzle;

public class Say extends Command {
    public Say(String name, String description, Game game) {
        super(name, description, game);
    }
    /**
     * Executes the say command, which tries to solve the puzzle in the player's location with the specified answer
     * @param args the additional arguments in the input, i.e. the attempted answer of the player
     */
    @Override
    public void execute(String[] args) {
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
