package main;

import main.itemsRelated.Inventory;

public class Player {
    private String name;
    private Inventory inventory = new Inventory();

    public Player(String name) {
        this.name = name;
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
