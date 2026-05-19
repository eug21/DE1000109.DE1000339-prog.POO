package exception;

public class ClienteNonTrovatoException extends Exception {
    public ClienteNonTrovatoException(String messaggio){
        super(messaggio);
    }
}
