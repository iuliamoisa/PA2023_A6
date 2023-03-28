package org.example;

public class InvalidCatalogException extends Throwable {
    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file.", ex);
    }
}


