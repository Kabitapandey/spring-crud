package com.internship.books.services;

import com.internship.books.entities.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    Book addBooks(Book book);

    List<Book> listBooks();

    Page<Book> paginationBooks(Integer size, Integer pageNo);

    Book updateBook(Book book, Integer id);

    void deleteBook(Integer id);

}
