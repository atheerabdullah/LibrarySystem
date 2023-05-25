package com.example.booksystem.Service;


import com.example.booksystem.ApiException.ApiException;
import com.example.booksystem.Model.Book;
import com.example.booksystem.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public List<Book> getAllBook() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void updateBook(Integer id, Book book) {
        Book updatedbook = bookRepository.findAllById(id);
        if (book == null) {
            throw new ApiException("the id not found ");
        }
        updatedbook.setTitle(updatedbook.getTitle());
        updatedbook.setAuthor(updatedbook.getAuthor());
        updatedbook.setISBN(updatedbook.getISBN());
        updatedbook.setCategory(updatedbook.getCategory());
        updatedbook.setNumberofpages(updatedbook.getNumberofpages());
    }

    public void deleteBook(Integer id) {
        Book book = bookRepository.findAllById(id);
        if (book == null) {
            throw new ApiException("");
        }
        bookRepository.delete(book);
    }


    public Book findBookById(Integer id) {
        Book book = bookRepository.findAllById(id);
        if (book == null) {
            throw new ApiException("the id not found , make sure you are enter a right a id ");
        }
        return book;
    }

    public List<Book> getBooksByCategory(String category) {
        List<Book> books = bookRepository.getBookByCategory(category);
        if (!books.isEmpty()) {
            return books;
        } else {
            throw new ApiException("No book found for category: " + category);
        }
    }


    public Book getBookByAuthor(String Author) {
        Book book = bookRepository.getBookByAuthor(Author);
        if (book == null) {
            throw new ApiException("the Author not found , make sure you are enter a right a Author ");
        }
        return book;

    }
    public Book getBookByTitle(String title) {
        Book book = bookRepository.getBookByTitle(title);
        if (book == null) {
            throw new ApiException("the title not found , make sure you are enter a right a title");
        }
        return book;

    }
    public List<Book> getBooksGreaterThanEqualTo50Pages() {
        List<Book> bookList = bookRepository.findBynumberofpagesGreaterThanEqual(50);
        return bookList;
    }
}


