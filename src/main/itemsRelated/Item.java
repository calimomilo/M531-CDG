package main.itemsRelated;

public abstract class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * returns the name of the item
     * @return the name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * returns the description of the item
     * @return the description of the item
     */
    public String getDescription() {
        return this.description;
    }


}
