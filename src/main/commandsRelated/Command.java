package main.commandsRelated;

import exceptions.InvalidCommandException;
import main.Game;


public abstract class Command implements ICommand{
    private final String verb;
    private final String description;
    private final Game game;

    public Command(String verb, String description, Game game) {
        this.verb = verb;
        this.description = description;
        this.game = game;
        this.game.getCommandRegistry().addCommand(this);
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
    public abstract void execute(String[] args) throws InvalidCommandException;
}
