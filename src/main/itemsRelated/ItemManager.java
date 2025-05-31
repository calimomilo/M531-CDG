package main.itemsRelated;

import main.Location;

public class ItemManager {
    
    private Inventory inventory;

    public ItemManager(Inventory inventory) {
        this.inventory = inventory;
    }

    public Boolean checkItemIsInLocation(Item item, Location location) {
        return location.getItems().contains(item);
    }

    public void addItemToInventory(Item item) {
        if(item instanceof Letter){
            inventory.addItem(item);
            System.out.println(item.getName() + " has been added to your inventory.");
        } else {
            System.out.println("You cannot add this item to your inventory.");
        }
    }


    public Inventory getInventory() {
        return inventory;
    }

}
