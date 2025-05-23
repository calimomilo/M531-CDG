package main.commandsRelated;

/**
 @param verb : the name of the command
 @param description : the description of the command
 @param execute : abstract method that takes an array of strings as an argument and performs the command.
 */

public abstract class Command implements ICommand{
    private String verb;
    private String description;

    public Command(String verb, String description) {
        this.verb = verb;
        this.description = description;
    }  

    public String getVerb() {
        return verb;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public abstract void execute(String[] args);
}
