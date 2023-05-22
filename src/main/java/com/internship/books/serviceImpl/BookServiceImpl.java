package com.internship.books.serviceImpl;

import com.internship.books.entities.Book;
import com.internship.books.repository.BookRepository;
import com.internship.books.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBooks(Book book) {
        this.bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> listBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Page<Book> paginationBooks(Integer size, Integer pageNo) {
        if (pageNo == null || size == null) {
            pageNo = 0;
            size = 1;
        }

        Pageable page = PageRequest.of(pageNo, size, Sort.by("id")
                .ascending());

        return this.bookRepository.findAll(page);
    }

    @Override
    public Book updateBook(Book book, Integer id) {
        Book books = this.bookRepository.findById(id)
                .orElseThrow(null);

        books.setAuthor(book.getAuthor());
        books.setCategory(book.getCategory());
        books.setName(book.getName());
        books.setPrice(book.getPrice());
        books.setRating(book.getRating());
        books.setIsbnNumber(book.getIsbnNumber());

        Book updatedBook = this.bookRepository.save(books);

        return updatedBook;
    }

    @Override
    public void deleteBook(Integer id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow();
        this.bookRepository.deleteById(id);
    }

}
