package main.itemsRelated;
import main.Inventory;
import main.Item;

public class Puzzle extends Item{

    String solution;
    Boolean isSolved = false;
    Key key;

    public Puzzle(String name, String description, String solution, Key key) {
        super(name, description);
        this.solution = solution;
        this.key = key;
    }

    public boolean solve(String attempt) {
        if (attempt.equals(solution)) {
            key.unlockLocation();
            return true;
        }
        return false;
    }

    public String getSolution() {
        return solution;
    }
    public Boolean getIsSolved() {
        return isSolved;
    }
    public void setIsSolved(Boolean isSolved) {
        this.isSolved = isSolved;
    }
    public void dropKey(Inventory inventory) { // mettre la clé dans l'inventaire du joueur
        if (key != null){
            // Ajouter la clé à l'inventaire du joueur
            inventory.addItem(key);
            System.out.println(key.getName() + " has been dropped into your inventory.");

        }
    }
}
