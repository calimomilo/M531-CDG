package exceptions;

public class UnknownItemException extends RuntimeException {
    public UnknownItemException(String objectToInspect) {
        super(objectToInspect);
    }
}
