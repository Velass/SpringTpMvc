package fr.diginamic.springmvc.exception;

public class EntityToCreateHasAnIdException extends RuntimeException {
    public EntityToCreateHasAnIdException(String message) {
        super(message);
    }
}