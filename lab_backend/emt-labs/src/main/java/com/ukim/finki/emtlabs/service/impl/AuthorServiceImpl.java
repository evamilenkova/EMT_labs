package com.ukim.finki.emtlabs.service.impl;

import com.ukim.finki.emtlabs.model.Author;
import com.ukim.finki.emtlabs.model.Country;
import com.ukim.finki.emtlabs.model.exceptions.AuthorNotFoundException;
import com.ukim.finki.emtlabs.model.exceptions.CountryNotFoundException;
import com.ukim.finki.emtlabs.repository.AuthorRepository;
import com.ukim.finki.emtlabs.repository.CountryRepository;
import com.ukim.finki.emtlabs.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Author save(String name, String surname, Long country_id) throws CountryNotFoundException {
        Country country=this.countryRepository.findById(country_id).orElseThrow(()->new CountryNotFoundException(country_id));
        return  this.authorRepository.save(new Author(name,surname,country));
    }

    @Override
    public Optional<Author> saveAuthor(Author author) throws CountryNotFoundException {
        return Optional.of(authorRepository.save(author));

    }

    @Override
    public void delete(long id) throws AuthorNotFoundException {
        Author a= this.findById(id).orElseThrow(()->new AuthorNotFoundException(id));
        this.authorRepository.delete(a);

    }
}
