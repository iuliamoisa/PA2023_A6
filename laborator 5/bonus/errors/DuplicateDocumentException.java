package org.example.errors;

public class DuplicateDocumentException extends Throwable {
    public DuplicateDocumentException(String id, String name) {
        super("The document " + name + " with id " + id + " is already in the catalog");
    }
}
