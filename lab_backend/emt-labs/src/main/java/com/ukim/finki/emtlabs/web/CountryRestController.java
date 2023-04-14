package com.ukim.finki.emtlabs.web;

import com.ukim.finki.emtlabs.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/country")
public class CountryRestController {

    private final CountryService countryService;


    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/add")
    public ResponseEntity<String> addAuthor() {
        return null;
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editBook(@PathVariable Long id){
        return null;
    }
}
