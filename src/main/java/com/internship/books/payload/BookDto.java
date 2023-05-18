package com.internship.books.payload;

import com.internship.books.entities.Author;

import java.util.Set;

public class BookDto {
    private int Id;

    private String isbnNumber;

    private String name;

    private String category;

    private double rating;

    private double price;

    private Set<Author> author;

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getIsbnNumber() {
        return this.isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Author> getAuthor() {
        return this.author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }

}
