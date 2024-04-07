package Exceptions;

public class NoAvailableConnectionsException extends RuntimeException {
    public NoAvailableConnectionsException(String message) {
        super(message);
    }
}
