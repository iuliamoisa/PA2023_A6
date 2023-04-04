package org.example.errors;

public class InvalidCatalogException extends Throwable {
    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file.", ex);
    }
}


