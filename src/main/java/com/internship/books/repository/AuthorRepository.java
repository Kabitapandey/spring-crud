package com.internship.books.repository;

import com.internship.books.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query(value = "SELECT avg(b.rating) as rating,a.first_name,a.last_name from book_authors ba \n" +
            "inner join book b on\n" +
            "b.id=ba.book_id\n" +
            "inner join author a on \n" +
            "a.id=ba.author_id\n" +
            "group by a.id;", nativeQuery = true)
    List<Map<String, Object>> getAvgRating();

    @Query(value = "SELECT a.first_name,a.last_name,avg(b.price) as avg_price from author a\n" +
            "inner join book_authors ba ON\n" +
            "ba.author_id=a.id\n" +
            "inner join book b on\n" +
            "b.id=ba.book_id \n" +
            "group by a.id;", nativeQuery = true)
    List<Map<String, Object>> getAvgPrice();

    @Query(value = "select b.name from book b\n" +
            "inner join book_authors ba\n" +
            "on b.id=ba.book_id \n" +
            "inner join author a\n" +
            "on a.id=ba.author_id\n" +
            "where a.id=:id", nativeQuery = true)
    List<Map<String, Object>> getAuthorsByBook(Integer id);
}
