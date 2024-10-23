package org.example.exception;

public class AbstractException extends RuntimeException{
    private String message;

    public AbstractException(String message){
        super(message);
    }
}
