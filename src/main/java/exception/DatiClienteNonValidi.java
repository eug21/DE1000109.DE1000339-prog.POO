package exception;

public class DatiClienteNonValidi extends RuntimeException {
    public DatiClienteNonValidi(String message) {
        super(message);
    }
}
