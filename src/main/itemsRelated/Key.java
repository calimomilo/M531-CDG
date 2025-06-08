package main.itemsRelated;

import main.Location;

public class Key extends Item{

    private Location locationLinked;

    public Key(String name, String description, Location locationLinked) {
        super(name, description);
        this.locationLinked = locationLinked;
    }

    /**
     * returns the location the key opens
     * @return the location the key opens
     */
    public Location getLocationLinked() {
        return locationLinked;
    }

    /**
     * unlocks the location linked to the key
     */
    public void unlockLocation(){
        this.locationLinked.setIsLocked(false);
    }
}
