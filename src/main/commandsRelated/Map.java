package main.commandsRelated;

public class Map extends Command {

    public Map(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String[] args) {
        if (args != null) {
            System.out.println("The command is not valid, please try again");
        } else {
            //TODO display the map here
        }
    }
}
