package main.commandsRelated;

/**
 @param CommandRegistry : create a registry of commands
    @param addCommand : add a command to the registry
    @param parseCommandInput : parse the user input and execute the command
    @param getCommands : get the list of commands
 */

import java.util.ArrayList;

public class CommandRegistry {
    private ArrayList<Command> commands;

    public CommandRegistry() {
        commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    //TODO: Add commands to the registry
    public void parseCommandInput(String userInput){
        userInput = userInput.trim();
    };


    public ArrayList<Command> getCommands() {
        return commands;
    }

    

}
