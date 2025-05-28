package main.itemsRelated;

import main.Location;

import main.Item;

public class Key extends Item{

    private Location location;

    public Key(String name, String description, Location location) {
        super(name, description);
        this.location = location;
    }
}
