package com.ukim.finki.emtlabs.repository;

import com.ukim.finki.emtlabs.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
