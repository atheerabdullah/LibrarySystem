package com.example.booksystem.Repository;

import com.example.booksystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findAllById(Integer id);

    List<Book> getBookByCategory(String category);

    List<Book> findBynumberofpagesGreaterThanEqual(int numberOfPages);

    Book getBookByAuthor(String category);

    Book getBookByTitle(String title);

    //    Get book have pages more then 300  - JPQL
    //    SELECT b FROM Book b WHERE b.numberOfPages >= 50







}
