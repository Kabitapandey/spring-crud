package com.internship.books.services;

import com.internship.books.entities.Author;

import java.util.List;

public interface AuthorService {
    void addAuthor(Author author);

    List<Author> listAuthors();

    Author updateAuthor(Author author, Integer id);

    void deleteAuthor(Integer id);
}
