package main.commandsRelated;

public class CommandHistoryLogger implements ICommandObserver {
    @Override
    public void onCommandExecuted(String command) {
        // just log the command to the console
        System.out.println("[History] Command executed: " + command);
    }
}