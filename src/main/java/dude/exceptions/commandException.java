package dude.exceptions;

public class commandException extends Exception { 
    public commandException(String errorMessage) {
        super(errorMessage);
    }
}