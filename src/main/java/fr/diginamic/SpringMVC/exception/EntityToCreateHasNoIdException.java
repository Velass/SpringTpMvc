package fr.diginamic.springmvc.exception;

public class EntityToCreateHasNoIdException extends RuntimeException {
    public EntityToCreateHasNoIdException() {
        super("Soucis avec La création d'une entité avec un ID.");
    }
}
