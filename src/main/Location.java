package main;

import java.util.ArrayList;

import main.itemsRelated.Item;
import utils.IPrintable;

public class Location implements IPrintable{
    private String name;
    private String description;
    private ArrayList<Item> items = new ArrayList<>();
    private boolean isLocked;

    /**
     * Creates a new location with the specified parameters
     * @param name name of the location
     * @param description description of the location
     * @param isLocked true if the location is locked, false otherwise
     */
    public Location(String name, String description, boolean isLocked) {
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
    }

    /**
     * returns the name of the location
     * @return the name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * returns the description of the location
     * @return the description of the location
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns the items ArrayList in the location
     * @return the items ArrayList in the location
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Defines the items in the location ; only used during the game initialisation
     * @param items : ArrayList of the items to put in the location
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * returns the item object with the specified name
     * @param name the name of the object to retrieve
     * @return the item object
     */
    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // If item is not in the ArrayList
    }

    /**
     * Removes a specific item from the location
     * @param item the item to remove
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Returns the locked status of the location
     * @return the locked status of the location
     */
    public boolean getIsLocked() {
        return isLocked;
    }

    /**
     * Defines the locked status of the location, only used once to unlock a locked location
     * @param isLocked the new status of the location
     */
    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * @return the text to display on the map with Array2DPrinter
     */
    @Override
    public String getPrintableString() {
        return name;
    }

    /**
     * Allows locked areas to be grayed out in the map display
     * @return true if the location is locked, false otherwise
     */
    @Override
    public boolean isGrayedOut() {
        return isLocked;
    }
}
