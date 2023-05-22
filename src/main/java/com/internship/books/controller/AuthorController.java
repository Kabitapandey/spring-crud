package com.internship.books.controller;

import com.internship.books.entities.Author;
import com.internship.books.services.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/author")
    public Map<String, String> addAuthor(@RequestBody Author author) {
        Map<String, String> response = new HashMap<>();

        this.authorService.addAuthor(author);

        response.put("msg", "Author added successfully");
        response.put("success", "true");

        return response;
    }

    @GetMapping("/author")
    public List<Author> listAuthor() {
        return this.authorService.listAuthors();
    }

    @PutMapping("/author/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable Integer id) {
        return this.authorService.updateAuthor(author, id);
    }

    @DeleteMapping("/author/{id}")
    public Map<String, String> deleteAuthor(@PathVariable Integer id) {
        Map<String, String> response = new HashMap<>();
        response.put("msg", "Author deleted successfully");
        response.put("success", "true");

        this.authorService.deleteAuthor(id);
        return response;
    }

    @GetMapping("/author/rating")
    public List<Map<String, Object>> getAuthorRating() {
        return this.authorService.getAvgRating();
    }

    @GetMapping("/author/price")
    public List<Map<String, Object>> getAuthorPrice() {
        return this.authorService.getAvgPrice();
    }
}
