package main.commandsRelated;


import exceptions.InvalidCommandException;
import exceptions.UnknownCommandException;

import javax.swing.*;
import java.util.*;

public class CommandRegistry {
    private TreeMap<String, Command> commands = new TreeMap<>();

    /**
     * Adds a command to the registry
     * @param command the command to add to the registry ; each command has to have a different verb attribute
     */
    public void addCommand(Command command) {
        commands.put(command.getVerb(), command);
    }

    /**
     * Parses the user input and calls the appropriate command with the additional arguments passed as an Array
     * @param userInput the input from the user
     */
    public void parseCommandInput(String userInput){
        userInput = userInput.toLowerCase().trim().replaceAll("\\s+"," ");
        String[] parts = userInput.split(" ");
        String verb = parts[0];
        if (parts.length > 1) {
            parts = Arrays.copyOfRange(parts, 1, parts.length);
        } else {
            parts[0] = "";
        }

        try {
            if (this.commands.containsKey(verb)) {
                this.commands.get(verb).execute(parts);
            } else {
                throw new UnknownCommandException();
            }
        }
        catch (InvalidCommandException e) {
            System.out.println("I do not understand \"" + userInput + "\"");
        }
        catch (UnknownCommandException e) {
            System.out.println("I do not know the command \"" + verb + "\"\nHint : type \"help\" for available commands");
        }


    };

    public TreeMap<String, Command> getCommands() {
        return commands;
    }

    

}
