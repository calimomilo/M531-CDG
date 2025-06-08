package main.commandsRelated;


import exceptions.InvalidCommandException;
import exceptions.ItemNotInLocationException;
import exceptions.UnknownCommandException;
import main.Game;
import exceptions.ItemNotInInventoryException;

import java.util.*;
import java.io.*;
public class CommandRegistry {
    private TreeMap<String, Command> commands = new TreeMap<>();
    private ArrayList<ICommandObserver> observers = new ArrayList<>();
    private ArrayList<String> commandHistory = new ArrayList<>();
    private String historyFile = "command_history.txt";
    private boolean isReplayingHistory = false;

    /**
     * Adds an observer to the command registry
     * @param observer the observer to add
     */
    public void addObserver(ICommandObserver observer) {
        observers.add(observer);
    }

    /**
     * notifies the observers of the inputted command
     * @param command the inputted command
     */
    private void notifyObservers(String command) {
        for (ICommandObserver observer : observers) {
            observer.onCommandExecuted(command);
        }
    }

    /**
     * sets the name of the command history file
     * @param filename the name of the command history file
     */
    public void setHistoryFile(String filename) {
        this.historyFile = filename;
    }

    /**
     * writes the inputted command in the command history file
     * @param command the inputted command
     */
    public void saveCommand(String command) {
        try (FileWriter fw = new FileWriter(historyFile, true)) {
            fw.write(command + "\n");
        } catch (IOException e) {
            System.out.println("Error saving command: " + e.getMessage());
        }
    }

    /**
     * replays all the commands saved to the command history file
     * @param game the game the command registry is part of
     */
    public void loadAndReplayCommands(Game game) {
        isReplayingHistory = true;
        try (BufferedReader br = new BufferedReader(new FileReader(historyFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                parseCommandInput(line);
            }
        } catch (IOException e) {
            // System.out.println("No previous history found.");
        }
        isReplayingHistory = false;
    }

    /**
     * Adds a command to the registry
     * @param command the command to add to the registry ; each command has to have a different verb attribute
     */
    public void addCommand(Command command) {
        commands.put(command.getVerb(), command);
    }

    /**
     * Parses the user input and calls the appropriate command with the additional arguments passed as an Array
     * @param userInput the input from the user
     */
    public void parseCommandInput(String userInput){
        userInput = userInput.toLowerCase().trim().replaceAll("\\s+"," ");
        String[] parts = userInput.split(" ");
        String verb = parts[0];
        if (parts.length > 1) {
            parts = Arrays.copyOfRange(parts, 1, parts.length);
        } else {
            parts[0] = "";
        }

        try {
            if (this.commands.containsKey(verb)) {
                this.commands.get(verb).execute(parts);
                commandHistory.add(userInput);
                if (!isReplayingHistory) {
                    saveCommand(userInput); // Save to file only if not replaying
                }
                notifyObservers(userInput); // Notify observers
            } else {
                throw new UnknownCommandException();
            }
        } catch (UnknownCommandException e) {
            System.out.println("I do not know the command \"" + verb + "\".\nHint : type help to see the list of available commands.");
        } catch (InvalidCommandException e) {
            System.out.println("I do not understand \"" + userInput + "\".");
        } catch (ItemNotInInventoryException e) {
            System.out.println("The \"" + e.getMessage() + "\" is not in your inventory.");
        } catch (ItemNotInLocationException e) {
            System.out.println("There is no \"" + e.getMessage() + "\" here.");
        }
    };

    /**
     * returns the TreeMap of the commands
     * @return the TreeMap of the commands
     */
    public TreeMap<String, Command> getCommands() {
        return commands;
    }

    

}
