package com.ukim.finki.emtlabs.model.exceptions;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(Long id) {
        super("Book with "+id+" not found");
    }
}
