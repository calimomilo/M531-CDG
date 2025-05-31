package exceptions;

public class ItemNotInInventoryException extends RuntimeException {
    public ItemNotInInventoryException(String item) {
        super(item);
    }
}
