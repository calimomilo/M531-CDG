package main.commandsRelated;


import exceptions.InvalidCommandException;
import exceptions.UnknownItemException;

public interface ICommand {

    /**
     * Executes the command with the eventual specified arguments
     * @param args the additional arguments in the input
     */
    void execute(String[] args) throws InvalidCommandException, UnknownItemException;

}
