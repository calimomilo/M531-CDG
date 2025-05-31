package main.commandsRelated;


public interface ICommand {

    /**
     * Executes the command with the eventual specified arguments
     * @param args the additional arguments in the input
     */
    void execute(String[] args);

}
