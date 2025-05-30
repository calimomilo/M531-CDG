package main.commandsRelated;


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

        if (this.commands.containsKey(verb)) {
            this.commands.get(verb).execute(parts);
            // TODO : mettre en place la gestion d'erreur
        }

    };

    public TreeMap<String, Command> getCommands() {
        return commands;
    }

    

}
