package com.ukim.finki.emtlabs.model;

import com.ukim.finki.emtlabs.model.enums.Category;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private Integer availableCopies;
    private Category category;


    public Book( String name, Author author, Integer availableCopies, Category category) {
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.category = category;
    }

    public Book() {

    }

    public Author getAuthor() {
        return author;
    }

}
