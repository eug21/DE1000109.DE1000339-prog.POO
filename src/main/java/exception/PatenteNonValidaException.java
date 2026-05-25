package exception;

public class PatenteNonValidaException extends RuntimeException {
    public PatenteNonValidaException(String message) {
        super(message);
    }
}
