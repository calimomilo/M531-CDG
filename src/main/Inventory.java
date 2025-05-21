package main;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();

    public Inventory(Item item) {
        this.items.add(item);
    }

    public void getItems() {
        for (Item i : items) {
            System.out.println(i);
        }
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // If item is not in the ArrayList
    }
}
