package main;

import java.util.ArrayList;

public class Location {
    private String name;
    private String description;
    private ArrayList<Item> items = new ArrayList<>();
    private boolean isLocked;

    /**
     * Constructeur de Location
     * @param name : nom de cette zone
     * @param description : description de cette zone
     * @param isLocked : état de cette zone (fermée / ouverte)
     */
    public Location(String name, String description, boolean isLocked) {
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
    }

    /**
     *
     * @return le nom de cette zone
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return la description de cette zone
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return ArrayList avec les items dans la zone
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Définir les items dans la zone, utilisé uniquement pendant la création de la zone
     * @param items : ArrayList des items à mettre dans la zone
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Enlever un item spécifique de la liste
     * @param item : item à enlever
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     *
     * @return l'état de cette zone
     */
    public boolean isLocked() {
        return isLocked;
    }

    /**
     * Définir l'état de la zone, utilisé une fois pour débloquer une zone fermée
     * @param isLocked
     */
    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }
}
