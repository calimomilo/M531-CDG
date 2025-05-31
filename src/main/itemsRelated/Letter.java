package main.itemsRelated;

public class Letter extends Item{

     private Puzzle puzzle;

     //links the letter to a puzzle
     public Letter(String name, String description, Puzzle puzzle) {
        super(name, description);
        this.puzzle = puzzle;
     }

}
