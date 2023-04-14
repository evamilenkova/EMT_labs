package com.ukim.finki.emtlabs.model.exceptions;

public class AuthorNotFoundException extends Exception{
    public AuthorNotFoundException(Long id) {
        super("Author with "+id+" not found");
    }
}
