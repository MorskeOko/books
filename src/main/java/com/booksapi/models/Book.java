package com.booksapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book{
    private int id;
    private String name;
    private String author;
    private String publication;
    private String category;
    private int pages;
    private double price;

    public Book(int id, String name, String author, String publication, String category, int pages, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.category = category;
        this.pages = pages;
        this.price = price;
    }
}