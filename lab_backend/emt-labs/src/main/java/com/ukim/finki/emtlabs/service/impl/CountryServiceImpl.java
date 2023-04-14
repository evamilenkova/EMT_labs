package com.ukim.finki.emtlabs.service.impl;

import com.ukim.finki.emtlabs.model.Country;
import com.ukim.finki.emtlabs.repository.CountryRepository;
import com.ukim.finki.emtlabs.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Country save(String name, String continent) {
        return this.countryRepository.save(new Country(name,continent));
    }

    @Override
    public Boolean exist(Long id) {
        return this.findById(id).isPresent();
    }
}
