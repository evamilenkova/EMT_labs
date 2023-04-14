package com.ukim.finki.emtlabs.web;

import com.ukim.finki.emtlabs.model.Author;
import com.ukim.finki.emtlabs.model.Book;
import com.ukim.finki.emtlabs.model.exceptions.AuthorNotFoundException;
import com.ukim.finki.emtlabs.model.exceptions.BookNotFoundException;
import com.ukim.finki.emtlabs.model.exceptions.CountryNotFoundException;
import com.ukim.finki.emtlabs.model.exceptions.NoMoreAvailableCopiesException;
import com.ukim.finki.emtlabs.service.AuthorService;
import com.ukim.finki.emtlabs.service.BookService;
import com.ukim.finki.emtlabs.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;
    private final CountryService countryService;

    public AuthorRestController(AuthorService authorService, CountryService countryService) {
        this.authorService = authorService;
        this.countryService = countryService;
    }
    @GetMapping("")
    public List<Author> getAuthors(){
        return this.authorService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) throws CountryNotFoundException {
        if(!this.countryService.exist(author.getCountry().getId())) {
            this.countryService.save(author.getCountry().getName(), author.getCountry().getContinent());
        }
        return this.authorService.saveAuthor(author)
                .map(b->ResponseEntity.ok().body(author))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> editAuthor(@PathVariable Long id){

        return this.authorService.findById(id).
                map(i->ResponseEntity.ok().body(i))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
}
