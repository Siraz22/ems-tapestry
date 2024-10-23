package org.example.exception;

public class BadRequestException extends AbstractException{
    public BadRequestException(String message){
        super(message);
    }
}
