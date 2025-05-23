package main;

import java.util.ArrayList;

public class WorldMap {
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
        if (containsLocation(location, allLocations)) {
            System.out.println("Error: Location already added"); // message d'erreur si la zone est déjà dans la carte
        } else if (getLocation(x, y, allLocations) != null) {
            System.out.println("Error: Location already at these coordinates"); // message d'erreur s'il y a déjà une zone aux coordonnées indiquées
        } else {
            addLocationToArrayList(location, x, y, allLocations);
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
     * Ajoute une zone dans le tableau des zones visitées au même endroit que dans la carte
     * @param location zone à ajouter
     */
    public void addDiscoveredLocation(Location location) {
        addLocationToArrayList(location, getLocationCoords(location, allLocations)[0], getLocationCoords(location, allLocations)[1], discoveredLocations);
    }

    /**
     * Ajoute une zone aux coordonnées données dans un tableau donné
     * @param location zone à ajouter
     * @param x coordonnée x
     * @param y coordonnée y
     * @param arrayList tableau dans lequel ajouter la zone
     */
    private void addLocationToArrayList(Location location, int x, int y, ArrayList<ArrayList<Location>> arrayList) {
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
        arrayList.get(x).add(y, location); // rajoute la zone aux coordonnées
        arrayList.get(x).remove(y+1); // fonction add pousse l'élément null qui était en y vers y+1, du coup, il faut l'enlever
    }

    /**
     * Vérifie si la zone donnée existe dans le tableau donné
     * @param location zone à vérifier
     * @param arrayList tableau à vérifier
     * @return
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
     *
     * @param x coordonnée x
     * @param y coordonnée y
     * @return la zone qui se trouve aux coordonnées données dans le tableau donné ou null si les coordonnées n'existent pas dans le tableau
     */
    public Location getLocation(int x, int y, ArrayList<ArrayList<Location>> arrayList) {
        if (x < arrayList.size() && y < arrayList.get(x).size()) {
            return arrayList.get(x).get(y);
        } else {
            System.out.println("Error : out of bounds");
            return null;
        }
    }

    /**
     *
     * @param location zone à trouver
     * @return les coordonnées de la zone donnée dans le tableau donné ou null si la zone n'est pas dans le tableau
     */
    public int[] getLocationCoords(Location location, ArrayList<ArrayList<Location>> arrayList) {
        for (ArrayList<Location> column : arrayList) {
            if (column.contains(location)) {
                return new int[] {arrayList.indexOf(column), column.indexOf(location)};
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
