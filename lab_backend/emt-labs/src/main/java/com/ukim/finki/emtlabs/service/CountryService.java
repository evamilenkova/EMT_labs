package com.ukim.finki.emtlabs.service;

import com.ukim.finki.emtlabs.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();
    Optional<Country> findById(Long id);
    Country save(String name, String continent);
    Boolean exist(Long id);

}
