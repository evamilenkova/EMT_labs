package com.ukim.finki.emtlabs.web;

import com.ukim.finki.emtlabs.model.Book;
import com.ukim.finki.emtlabs.model.enums.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryRestContoller {

    @GetMapping("")
    public List<Category> getBooks(){
        return List.of(Category.values());
    }
}
