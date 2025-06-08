package main.itemsRelated;

import main.Player;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * returns the ArrayList of the items in the inventory
     * @return the ArrayList of the items in the inventory
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }

    /**
     * Adds the specified item to the inventory
     * @param item the item to add
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Returns the item in the inventory with the specified name
     * @param name the name of the item to return
     * @return the item with the specified name
     */
    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // If item is not in the ArrayList
    }
}
