package main.commandsRelated;

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

    /**
     * returns the verb of this command
     * @return the verb of this command
     */
    public String getVerb() {
        return verb;
    }

    /**
     * returns the description of this command
     * @return the description of this command
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns the game this command is a part of
     * @return the game this command is a part of
     */
    public Game getGame() {
        return game;
    }

    @Override
    public abstract void execute(String[] args);
}
