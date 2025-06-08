package main.commandsRelated;

public class CommandHistoryLogger implements ICommandObserver {

    /**
     * Prints a message confirming the log of the inputted command (Currently disabled)
     * @param command the inputted command
     */
    @Override
    public void onCommandExecuted(String command) {

        // Print the command to the console, totally removable if you don't like it, but I found it funny and useful
        // System.out.println("[History] Command executed: " + command);
    }
}