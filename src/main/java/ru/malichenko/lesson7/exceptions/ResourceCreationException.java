package ru.malichenko.lesson7.exceptions;

public class ResourceCreationException extends RuntimeException {
    public ResourceCreationException(String message) {
        super(message);
    }
}
