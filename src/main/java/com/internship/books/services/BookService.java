package com.internship.books.services;

import com.internship.books.entities.Book;

import java.util.List;

public interface BookService {
    Book addBooks(Book book);

    List<Book> listBooks();

    Book updateBook(Book book, Integer id);

    void deleteBook(Integer id);
}
