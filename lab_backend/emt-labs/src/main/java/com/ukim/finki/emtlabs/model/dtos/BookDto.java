package com.ukim.finki.emtlabs.model.dtos;

import com.ukim.finki.emtlabs.model.enums.Category;
import lombok.Data;

@Data
public class BookDto {

    private String name;
    private Long authorId;
    private Integer availableCopies;
    private Category category;

}
