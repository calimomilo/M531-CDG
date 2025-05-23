package main.commandsRelated;

/**
 @param CommandRegistry : create a registry of commands
    @param addCommand : add a command to the registry
    @param parseCommandInput : parse the user input and execute the command
    @param getCommands : get the list of commands
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class CommandRegistry {
    private HashMap<String, Command> commands;

    public CommandRegistry() {
        commands = new HashMap<>();
    }

    public void addCommand(Command command) {
        commands.put(command.getVerb(), command);
    }

    /**
     * This function take the user input, parse it and call the command accordingly
     * @param userInput
     */
    public void parseCommandInput(String userInput){
        userInput = userInput.toLowerCase().trim().replaceAll("\\s+"," ");
        String[] parts = userInput.split(" ");
        String verb = parts[0];
        parts = Arrays.copyOfRange(parts, 1, (parts.length - 1));

        if (this.commands.containsKey(verb)) {
            this.commands.get(verb).execute(parts);
        } else {
            //TODO check this
            //sout a message with an error here?
        }

    };

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    

}
