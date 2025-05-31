package exceptions;

public class ItemNotInLocationException extends RuntimeException {
    public ItemNotInLocationException(String item) {
        super(item);
    }
}
