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
     * Ajoute une zone à la carte aux coordonnées indiquées
     * @param location zone à ajouter
     * @param x première coordonnée
     * @param y deuxième coordonnée
     */
    public void addLocation(Location location, int x, int y) {
        // TODO : implémenter fonction
        if (containsLocation(location)) {
            System.out.println("Error: Location already added"); // message d'erreur si la zone est déjà dans la carte
        } else if (getLocation(x, y) != null) {
            System.out.println("Error: Location already at these coordinates"); // message d'erreur s'il y a déjà une zone aux coordonnées indiquées
        } else {
            if (x >= allLocations.size()) { // si la coordonnée x est en dehors du tableau existant, rajoute le bon nombre de colonnes
                int add = x-allLocations.size();
                for (int i = 0; i <= add; i++) {
                    allLocations.add(new ArrayList<>());
                }
            }
            if (y >= allLocations.get(x).size()) { // si la coordonnée y est en dehors de la colonne existante, rajoute le bon nombre d'éléments null
                int add = y-allLocations.get(x).size();
                for (int i = 0; i <= add; i++) {
                    allLocations.get(x).add(null);
                }
            }
            allLocations.get(x).add(y, location); // rajoute la zone aux coordonnées
            allLocations.get(x).remove(y+1); // fonction add pousse l'élément null qui était en y vers y+1, du coup, il faut l'enlever
        }
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
