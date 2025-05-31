package main;

import main.itemsRelated.Inventory;

public class Player {
    private String name;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory(this);
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
