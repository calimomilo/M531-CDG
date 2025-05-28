package main.itemsRelated;
import main.Inventory;
import main.Item;

public class Puzzle extends Item{

    private String solution;
    private Boolean isSolved = false;
    private Key key;

    public Puzzle(String name, String description, String solution, Key item1) {
        super(name, description);
        this.solution = solution;
        this.key = item1;
    }


    // à voir si vous voulez que la commande Say appelle cette méthode
    public boolean solve(String attempt) {
        if (attempt.equals(solution)) {
            key.unlockLocation();
            isSolved = true;
            System.out.println("Puzzle solved! The key has been used to unlock the location.");
            dropKey(null);
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
