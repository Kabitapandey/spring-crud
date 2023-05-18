package com.internship.books.controller;

import com.internship.books.entities.Book;
import com.internship.books.payload.ApiResponse;
import com.internship.books.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public Book addBooks(@RequestBody Book book) {
        return this.bookService.addBooks(book);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.listBooks();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
        return this.bookService.updateBook(book, id);
    }

    @DeleteMapping("/books/{id}")
    public ApiResponse deleteBook(@PathVariable Integer id) {
        this.bookService.deleteBook(id);
        return new ApiResponse("Book deleted successfully!", 200);
    }
}
