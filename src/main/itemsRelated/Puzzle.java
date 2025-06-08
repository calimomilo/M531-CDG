package main.itemsRelated;

public class Puzzle extends Item {

    private String solution;
    private Boolean isSolved = false;
    private Key key;
    private ItemManager itemManager;

    public Puzzle(String name, String description, String solution, Key key, ItemManager itemManager) {
        super(name, description);
        this.solution = solution;
        this.key = key;
        this.itemManager = itemManager;
    }


    /**
     * Checks if the specified string is the solution of the puzzle
     * @param attempt the string attempted by the player
     * @return true if the attempt is correct, false otherwise
     */
    public boolean solve(String attempt) {
        if (attempt.equalsIgnoreCase(solution)) {
            isSolved = true;
            System.out.println("Congratulations, you solved this puzzle!");
            dropKey();
            return true;
        }
        return false;
    }

    /**
     * returns the solved status of the puzzle
     * @return the solved status of the puzzle
     */
    public Boolean getIsSolved() {
        return isSolved;
    }

    /**
     * defines the new solved status of the puzzle
     * @param isSolved the new solved status of the puzzle
     */
    public void setIsSolved(Boolean isSolved) {
        this.isSolved = isSolved;
    }

    /**
     * adds the key linked to the puzzle to the player's inventory
     */
    private void dropKey() { // mettre la clé dans l'inventaire du joueur
        if (key != null){
            itemManager.moveItemToInventory(key);
        }
    }
}
