package com.internship.books.repository;

import com.internship.books.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
//    @Query("")
//    List<Book> getAvgRating();
}
