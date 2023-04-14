package com.ukim.finki.emtlabs.service;

import com.ukim.finki.emtlabs.model.Book;
import com.ukim.finki.emtlabs.model.dtos.BookDto;
import com.ukim.finki.emtlabs.model.enums.Category;
import com.ukim.finki.emtlabs.model.exceptions.AuthorNotFoundException;
import com.ukim.finki.emtlabs.model.exceptions.BookNotFoundException;
import com.ukim.finki.emtlabs.model.exceptions.NoMoreAvailableCopiesException;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();
    Optional<Book> findById(Long id);
    void deleteById(Long id);
    Optional<Book> save(String name, Long authorId, Integer availableCopies, Category category) throws AuthorNotFoundException;
    Optional<Book>  saveBook(Book book);
    Optional<Book>  saveBookDto(BookDto book) throws AuthorNotFoundException;
    Optional<Book> update(Long id,String name, Long authorId,Integer availableCopies, Category category) throws BookNotFoundException, AuthorNotFoundException;
    Optional<Book> markAsBorrowed(Long id) throws BookNotFoundException, NoMoreAvailableCopiesException;



}