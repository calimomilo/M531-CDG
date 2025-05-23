package main.commandsRelated;

/**
 @param CommandRegistry : create a registry of commands
    @param addCommand : add a command to the registry
    @param parseCommandInput : parse the user input and execute the command
    @param getCommands : get the list of commands
 */

import java.util.ArrayList;
import java.util.HashMap;

public class CommandRegistry {
    private HashMap<String, Command> commands;

    public CommandRegistry() {
        commands = new HashMap<>();
    }

    public void addCommand(Command command) {
        commands.put(command.getVerb(), command);
    }

    //TODO: Add commands to the registry
    public void parseCommandInput(String userInput){
        userInput = userInput.trim();
    };


    public HashMap<String, Command> getCommands() {
        return commands;
    }

    

}
