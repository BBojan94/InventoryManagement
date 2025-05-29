package com.bojan.inventorymanagement.exception;

/**
 * Custom exception used when a requested resource (e.g., entity by ID) is not found.
 * Extends RuntimeException so it can be thrown without being explicitly declared.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor with a custom error message.
     *
     * @param message the detail message explaining what resource was not found
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

}
