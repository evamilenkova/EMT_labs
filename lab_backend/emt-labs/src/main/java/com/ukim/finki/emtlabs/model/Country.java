package com.ukim.finki.emtlabs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Country {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String continent;

        public Country(String name, String continent) {
            this.name = name;
            this.continent = continent;
        }

        public Country() {

        }
    }
