package main.commandsRelated;

public class CommandHistoryLogger implements ICommandObserver {
    @Override
    public void onCommandExecuted(String command) {
        // Print the command to the console, totally removable if you dont like it but i found it funny and useful
        System.out.println("[History] Command executed: " + command);
    }
}