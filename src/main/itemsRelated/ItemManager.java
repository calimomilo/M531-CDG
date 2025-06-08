package main.itemsRelated;

import main.Game;

public class ItemManager {
    
    private Game game;

    public ItemManager(Game game) {
        this.game = game;
    }

    /**
     * moves the specified item to the player's inventory
     * @param item the item to move to the inventory
     */
    public void moveItemToInventory(Item item) {
        game.getWorldMap().getPlayerLocation().getItems().remove(item);
        game.getPlayer().getInventory().addItem(item);
        System.out.println("The " + item.getName().toLowerCase() + " has been added to your inventory.");
    }

}
