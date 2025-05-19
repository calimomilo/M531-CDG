package main.commandsRelated;

public abstract class Command implements ICommand{
    private String verb;
    private String description;

    public Command(String name, String description) {
        this.verb = name;
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
