package main.commandsRelated;

public class Move extends Command {

    public Move(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(String[] args) {
        if (args == null) {
            System.out.println("The command is not valid, please try again");
        } else {
            //TODO move the player to the desired room
        }
    }
}
