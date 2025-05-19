package main.commandsRelated;

/**
 * @param Look class extends Command class and implements the execute method.
 */

public class Look extends Command{

    public Look() {
        super("look", "Look around the environment.");
    }

    @Override
    public void execute(String[] args) {
        System.out.println("You look around and see a beautiful landscape.");
    }

}
