package main;

public class ItemManager {
    
    private Inventory inventory;

    public ItemManager(Inventory inventory) {
        this.inventory = inventory;
    }

    public Boolean checkItemIsInLocation(Item item, Location location) {
        return location.getItems().contains(item);
    }

    public void addItemToInventory(Item item) {
        inventory.addItem(item);
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void addItem(Item item2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }

}
