package Exceptions;

import java.io.Serializable;

public class PoolExhaustedException extends Exception implements Serializable {
    public PoolExhaustedException() {
        super("A Pool está cheia!");
    }
}