package com.example.booksystem.Controller;


import com.example.booksystem.Model.Book;
import com.example.booksystem.Model.Librarian;
import com.example.booksystem.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Librarians")
@AllArgsConstructor
public class LibrarianController {

    private final LibrarianService librarianService;


    @GetMapping("/getAllLibraries")
    public ResponseEntity<List<Librarian>> getLibraries() {
        List<Librarian> LibrarianList = librarianService.getLibraries();
        return ResponseEntity.status(HttpStatus.OK).body(LibrarianList);
    }
    @PostMapping("/addLibrarian")
    public ResponseEntity addBook(@RequestBody @Valid Librarian librarian) {
        librarianService.addBook(librarian);
        return ResponseEntity.status(200).body("Librarian added");

    }
    @PutMapping("/updateLibrarian/{id}")
    public ResponseEntity updateLibrarian(@Valid @RequestBody Librarian librarian, @PathVariable Integer id) {
        librarianService.updateLibrarian(id, librarian);
        return ResponseEntity.status(200).body("The librarian updated");
    }

    @DeleteMapping("/deleteLibrarian/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id) {
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body("The librarian deleted ");
    }
    // check All user By username And Passwd
    @GetMapping("/get-Librarian/{username}/{password}")
    public ResponseEntity findUserByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        Librarian librarian = librarianService.CheckAllByUsernameAndPassword(username, password);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/getLibrarianByEmail/{email}")
    public ResponseEntity getLibrarianByEmail(@PathVariable String email) {
        Librarian librarian = librarianService.getLibrarianByEmail(email);
        return ResponseEntity.status(200).body(email);
    }




}
