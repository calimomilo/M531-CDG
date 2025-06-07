package main;

import java.util.ArrayList;

public class WorldMap {
    private ArrayList<ArrayList<Location>> allLocations = new ArrayList<>();
    private ArrayList<ArrayList<Location>> discoveredLocations = new ArrayList<>();
    private Location playerLocation;

    /**
     * @return the 2D ArrayList of all existing locations
     */
    public ArrayList<ArrayList<Location>> getAllLocations() {
        return allLocations;
    }

    /**
     * Adds a location at the specified coordinates to the ArrayList with all existing locations
     * @param location the location to be added
     * @param x first coordinate (horizontal)
     * @param y second coordinate (vertical)
     */
    public void addLocation(Location location, int x, int y) {
        if (containsLocation(location, allLocations)) {
            System.out.println("Error: Location " + location.getName() + " already added"); // message d'erreur si la zone est déjà dans la carte
        } else if (getLocation(x, y, allLocations) != null) {
            System.out.println("Error: Location " + location.getName() + " already at these coordinates"); // message d'erreur s'il y a déjà une zone aux coordonnées indiquées
        } else {
            addLocationToArrayList(location, x, y, allLocations);
        }
    }

    /**
     * @return the 2DArrayList of the locations discovered by the player
     */
    public ArrayList<ArrayList<Location>> getDiscoveredLocations() {
        return discoveredLocations;
    }

    /**
     * Adds a location from the ArrayList of all locations to the ArrayList of discovered locations at the same coordinates
     * @param location the location to be added ; has to exist in the allLocations ArrayList
     */
    public void addDiscoveredLocation(Location location) {
        addLocationToArrayList(location, getLocationCoords(location)[0], getLocationCoords(location)[1], discoveredLocations);
    }

    /**
     * Adds a location to the specified 2D ArrayList at the specified coordinates
     * @param location the location to be added
     * @param x first coordinate (horizontal)
     * @param y second coordinate (vertical)
     * @param arrayList 2D ArrayList in which to add the location
     */
    public void addLocationToArrayList(Location location, int x, int y, ArrayList<ArrayList<Location>> arrayList) {
        if (x >= arrayList.size()) { // si la coordonnée x est en dehors du tableau existant, rajoute le bon nombre de colonnes
            int add = x-arrayList.size();
            for (int i = 0; i <= add; i++) {
                arrayList.add(new ArrayList<>());
            }
        }
        if (y >= arrayList.get(x).size()) { // si la coordonnée y est en dehors de la colonne existante, rajoute le bon nombre d'éléments null
            int add = y-arrayList.get(x).size();
            for (int i = 0; i <= add; i++) {
                arrayList.get(x).add(null);
            }
        }
        arrayList.get(x).set(y, location); // rajoute la zone aux coordonnées
    }

    /**
     * Verifies that the location exists in the specified 2D ArrayList
     * @param location the location to find
     * @param arrayList the 2D ArrayList in which to look for the location
     * @return true if the location is in the ArrayList, false otherwise
     */
    public boolean containsLocation(Location location, ArrayList<ArrayList<Location>> arrayList) {
        boolean contains = false;
        for (ArrayList<Location> column : arrayList) {
            if (column.contains(location)) {
                contains = true;
            }
        }
        return contains;
    }

    /**
     * Returns the location at the specified coordinates in the specified 2D ArrayList
     * @param x first coordinate (horizontal)
     * @param y second coordinate (vertical)
     * @return the location found at the coordinates, or null if there isn't one
     */
    public Location getLocation(int x, int y, ArrayList<ArrayList<Location>> arrayList) {
        if (x < arrayList.size() && x >= 0 && y < arrayList.get(x).size() && y >= 0) {
            return arrayList.get(x).get(y);
        } else {
            //System.out.println("Error : out of bounds");
            return null;
        }
    }

    /**
     * Returns the coordinates of the specified location in the allLocations ArrayList. The coordinates for the same location in the discoveredLocations ArrayList are the same
     * @param location the location to find
     * @return an Array with the coordinates of the location, or null if the location isn't in the ArrayList
     */
    public int[] getLocationCoords(Location location) {
        for (ArrayList<Location> column : allLocations) {
            if (column.contains(location)) {
                return new int[] {allLocations.indexOf(column), column.indexOf(location)};
            }
        }
        System.out.println("Error : location " + location.getName() + " not found");
        return null;
    }

    public Location getPlayerLocation() {
        return playerLocation;
    }

    public int[] getPlayerLocationCoords() {
        return getLocationCoords(playerLocation);
    }

    public void setPlayerLocation(Location playerLocation) {
        this.playerLocation = playerLocation;
        addDiscoveredLocation(playerLocation);
    }

}
