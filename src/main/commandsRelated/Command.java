package main.commandsRelated;

import main.Game;

/**
 @param verb : the name of the command
 @param description : the description of the command
 @param execute : abstract method that takes an array of strings as an argument and performs the command.
 */

public abstract class Command implements ICommand{
    private final String verb;
    private final String description;
    private final Game game;

    public Command(String verb, String description, Game game) {
        this.verb = verb;
        this.description = description;
        this.game = game;
    }  

    public String getVerb() {
        return verb;
    }

    public String getDescription() {
        return description;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public abstract void execute(String[] args);
}
