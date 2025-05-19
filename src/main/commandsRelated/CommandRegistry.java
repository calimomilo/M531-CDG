package main.commandsRelated;

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
    };


    public ArrayList<Command> getCommands() {
        return commands;
    }

    

}
