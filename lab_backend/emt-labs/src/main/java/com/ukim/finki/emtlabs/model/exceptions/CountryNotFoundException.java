package com.ukim.finki.emtlabs.model.exceptions;

public class CountryNotFoundException extends Exception{

    public CountryNotFoundException(Long id) {
        super("Country with id "+ id + "not found");
    }
}