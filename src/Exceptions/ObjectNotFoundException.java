package Exceptions;

import java.io.Serializable;

public class ObjectNotFoundException extends Exception implements Serializable {
    public ObjectNotFoundException() {
        super("O objeto não foi encontrado!");
    }
}