package com.internship.books.controller;

import com.internship.books.entities.Book;
import com.internship.books.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Book> books() {
        return this.bookService.listBooks();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
        return this.bookService.updateBook(book, id);
    }

    @DeleteMapping("/books/{id}")
    public Map<String, String> deleteBook(@PathVariable Integer id) {
        Map<String, String> response = new HashMap<>();
        response.put("msg", "Author deleted successfully");
        response.put("success", "true");
        this.bookService.deleteBook(id);
        return response;
    }

    @GetMapping("/books/pagination")
    public Page<Book> getPaginatedBooks(@RequestParam(required = false) Integer pageNo, @RequestParam(required = false) Integer size) {
        return this.bookService.paginationBooks(size, pageNo);
    }

}
