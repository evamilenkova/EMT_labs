package com.ukim.finki.emtlabs.service.impl;

import com.ukim.finki.emtlabs.model.Author;
import com.ukim.finki.emtlabs.model.Book;
import com.ukim.finki.emtlabs.model.dtos.BookDto;
import com.ukim.finki.emtlabs.model.enums.Category;
import com.ukim.finki.emtlabs.model.exceptions.AuthorNotFoundException;
import com.ukim.finki.emtlabs.model.exceptions.BookNotFoundException;
import com.ukim.finki.emtlabs.model.exceptions.NoMoreAvailableCopiesException;
import com.ukim.finki.emtlabs.repository.AuthorRepository;
import com.ukim.finki.emtlabs.repository.BookRepository;
import com.ukim.finki.emtlabs.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public   Optional<Book>  save(String name, Long authorId, Integer availableCopies, Category category) throws AuthorNotFoundException {
        Author author=this.authorRepository.findById(authorId).orElse(null);
        Book book=new Book(name,author,availableCopies, category);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public   Optional<Book>  saveBook(Book book) {
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> saveBookDto(BookDto book) throws AuthorNotFoundException {
        Author author=this.authorRepository.findById(book.getAuthorId()).orElseThrow(()->new AuthorNotFoundException(book.getAuthorId()));
        Book newBook=new Book(book.getName(),author,book.getAvailableCopies(),book.getCategory());
        return this.saveBook(newBook);
    }

    @Override
    public Optional<Book> update(Long id, String name, Long authorId, Integer availableCopies,  Category category) throws BookNotFoundException, AuthorNotFoundException {
        Book b=this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        Author author=this.authorRepository.findById(authorId).orElseThrow(()-> new AuthorNotFoundException(authorId));
        b.setAuthor(author);
        b.setCategory(category);
        b.setName(name);
        b.setAvailableCopies(availableCopies);
        return this.saveBook(b);

    }



    @Override
    public Optional<Book> markAsBorrowed(Long id) throws BookNotFoundException, NoMoreAvailableCopiesException {
        Book b=this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        int copies=b.getAvailableCopies();
        if(copies==0) throw  new NoMoreAvailableCopiesException(id);
        else b.setAvailableCopies(copies-1);
        return this.saveBook(b);
    }
}

