package dude.exceptions;

public class unknownException extends Exception { 
    public unknownException(String errorMessage) {
        super(errorMessage);
    }
}