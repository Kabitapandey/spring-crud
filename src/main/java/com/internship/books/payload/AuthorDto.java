package com.internship.books.payload;

import com.internship.books.entities.Book;

import java.util.Set;

public class AuthorDto {
    private int Id;

    private String firstName;

    private String lastName;

    private String country;

    private Set<Book> books;

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public String country() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Book> getBooks() {
        return this.getBooks();
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}
