package com.example.booksystem.Controller;


import com.example.booksystem.Model.Book;
import com.example.booksystem.Service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAllBook();
        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity findBookById(@PathVariable Integer id) {
        Book book = bookService.findBookById(id);
        return ResponseEntity.status(200).body(book);
    }

    @GetMapping("/getBooksByCategory/{category}")
    public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable String category) {
        List<Book> books = bookService.getBooksByCategory(category);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/getBook/{Author}")
    public ResponseEntity getBookByAuthor(@PathVariable String Author) {
        Book book = bookService.getBookByAuthor(Author);
        return ResponseEntity.status(200).body(book);
    }

    @GetMapping("/getBookGreater/")
    public ResponseEntity getBooksGreaterThanEqualTo50Pages() {
        List<Book> bookList = bookService.getBooksGreaterThanEqualTo50Pages();
        return ResponseEntity.status(200).body(bookList);
    }

    @GetMapping("/getBook/{title}")
    public ResponseEntity getBookByTitle(@PathVariable String title) {
        Book book = bookService.getBookByTitle(title);
        return ResponseEntity.status(200).body(book);
    }

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody @Valid Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(200).body("book added");

    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity updateBook(@Valid @RequestBody Book book, @PathVariable Integer id) {
        bookService.updateBook(id, book);
        return ResponseEntity.status(200).body("The Book updated");
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("The Book deleted ");
    }
}
