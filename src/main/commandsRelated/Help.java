package main.commandsRelated;

import main.Game;

import java.util.Map;

public class Help extends Command {
    public Help(String verb, String description, Game game) {
        super(verb, description, game);
    }

    /**
     * Executes the help command, which displays the commands of the game
     * @param args arguments of the command, should be empty for the command to work
     */
    @Override
    public void execute(String[] args) {
        if(args[0].isEmpty()){
            for (Map.Entry<String, Command> entry : getGame().getCommandRegistry().getCommands().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().getDescription());
            }
        }
    }
}
