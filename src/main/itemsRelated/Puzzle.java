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


    // à voir si vous voulez que la commande Say appelle cette méthode
    public boolean solve(String attempt) {
        if (attempt.equals(solution)) {
            isSolved = true;
            System.out.println("Congratulations, you solved this puzzle!");
            dropKey();
            // TODO : should the puzzle be removed once its solved?
            return true;
        }
        return false;
    }

    public Boolean getIsSolved() {
        return isSolved;
    }
    public void setIsSolved(Boolean isSolved) {
        this.isSolved = isSolved;
    }

    private void dropKey() { // mettre la clé dans l'inventaire du joueur
        if (key != null){
            itemManager.moveItemToInventory(key);
        }
    }
}
