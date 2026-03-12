package org.ies.tierno.exceptions;

public class BookNotFoundException extends Exception {
    private final String isbn;

    public BookNotFoundException(String isbn) {
        super("El libro con ISBN: " + isbn +", no se ha encontrado");
        this.isbn = isbn;
    }
}
