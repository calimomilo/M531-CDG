package main;

import main.itemsRelated.Inventory;

public class Player {
    private String name;
    private Inventory inventory = new Inventory();

    public Player(String name) {
        this.name = name;
    }

    /**
     * returns the name of the player
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * returns the player's inventory object
     *
     * @return the player's inventory object
     */
    public Inventory getInventory() {
        return inventory;
    }
}
