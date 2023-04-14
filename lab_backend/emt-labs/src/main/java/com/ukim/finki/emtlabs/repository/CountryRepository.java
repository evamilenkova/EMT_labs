package com.ukim.finki.emtlabs.repository;

import com.ukim.finki.emtlabs.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
