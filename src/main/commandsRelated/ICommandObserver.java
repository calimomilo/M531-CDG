package main.commandsRelated;

public interface ICommandObserver {
    /**
     * The eventual code executed after the inputted command is logged in the command history file
     * @param command the inputted command
     */
    void onCommandExecuted(String command);
}