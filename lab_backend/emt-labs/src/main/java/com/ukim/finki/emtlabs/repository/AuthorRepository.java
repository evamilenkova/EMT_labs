package com.ukim.finki.emtlabs.repository;


import com.ukim.finki.emtlabs.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
