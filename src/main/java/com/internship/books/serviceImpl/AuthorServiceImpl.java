package com.internship.books.serviceImpl;

import com.internship.books.entities.Author;
import com.internship.books.exception.NotAllowedException;
import com.internship.books.repository.AuthorRepository;
import com.internship.books.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void addAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public List<Author> listAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Author author, Integer id) {
        Author authors = this.authorRepository.findById(id)
                .orElseThrow(null);

        authors.setCountry(author.getCountry());
        authors.setFirstName(author.getFirstName());
        authors.setLastname(author.getLastName());

        Author updatedAuthor = this.authorRepository.save(authors);

        return updatedAuthor;
    }

    @Override
    public void deleteAuthor(Integer id) {
        List<Map<String, Object>> getAuthors = this.authorRepository.getAuthorsByBook(id);
        System.out.println(getAuthors);
        if (getAuthors.size() >= 1) {
            throw new NotAllowedException();
        }

        this.authorRepository.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> getAvgRating() {
        return this.authorRepository.getAvgRating();

    }

    @Override
    public List<Map<String, Object>> getAvgPrice() {
        return this.authorRepository.getAvgPrice();
    }

}
