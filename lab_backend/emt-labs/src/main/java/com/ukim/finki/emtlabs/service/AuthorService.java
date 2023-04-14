package com.ukim.finki.emtlabs.service;

import com.ukim.finki.emtlabs.model.Author;
import com.ukim.finki.emtlabs.model.exceptions.AuthorNotFoundException;
import com.ukim.finki.emtlabs.model.exceptions.CountryNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();
    Optional<Author> findById(Long id);
    Author save(String name, String surname, Long country_id) throws CountryNotFoundException;
    Optional<Author> saveAuthor(Author author) throws CountryNotFoundException;
    void delete(long id) throws AuthorNotFoundException;


}
