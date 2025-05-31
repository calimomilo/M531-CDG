package main.itemsRelated;

import main.Location;

public class Key extends Item{

    private Location locationLinked;

    public Key(String name, String description, Location locationLinked) {
        super(name, description);
        this.locationLinked = locationLinked;
    }

    public Location getLocationLinked() {
        return locationLinked;
    }

    public void unlockLocation(){
        this.locationLinked.setIsLocked(false);
    }
}
