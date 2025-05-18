package main;

import java.util.ArrayList;

public class Map {
    private ArrayList<ArrayList<Location>> allLocations = new ArrayList<>();
    private ArrayList<ArrayList<Location>> discoveredLocations = new ArrayList<>();
    private Location playerLocation;

    /**
     *
     * @return le tableau 2D des zones de la carte
     */
    public ArrayList<ArrayList<Location>> getAllLocations() {
        return allLocations;
    }

    /**
     * Ajoute une zone à la carte
     * @param location zone à ajouter
     * @param x première coordonnée
     * @param y deuxième coordonnée
     */
    public void addLocation(Location location, int x, int y) {
        // TODO : implémenter fonction
    }

    /**
     *
     * @return le tableau 2D des zones déjà visitées par le joueur
     */
    public ArrayList<ArrayList<Location>> getDiscoveredLocations() {
        return discoveredLocations;
    }

    /**
     * Ajoute une zone à la liste des zones visitées
     * @param location
     */
    public void addDiscoveredLocation(Location location) {
        // TODO : implémenter fonction
    }

    public boolean containsLocation(Location location) {
        boolean contains = false;
        for (ArrayList<Location> column : allLocations) {
            if (column.contains(location)) {
                contains = true;
            }
        }
        return contains;
    }

    public Location getLocation(int x, int y) {
        if (x < allLocations.size() && y < allLocations.get(x).size()) {
            return allLocations.get(x).get(y);
        } else {
            System.out.println("Error : out of bounds");
            return null;
        }
    }

    public int[] getLocationCoords(Location location) {
        for (ArrayList<Location> column : allLocations) {
            if (column.contains(location)) {
                return new int[] {allLocations.indexOf(column), column.indexOf(location)};
            }
        }
        System.out.println("Error : location not found");
        return null;
    }

    /**
     *
     * @return la zone où se trouve le joueur
     */
    public Location getPlayerLocation() {
        return playerLocation;
    }

    /**
     * Définit la nouvelle zone du joueur
     * @param playerLocation : nouvelle zone du joueur
     */
    public void setPlayerLocation(Location playerLocation) {
        this.playerLocation = playerLocation;
    }
}
