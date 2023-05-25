package com.example.booksystem.Service;


import com.example.booksystem.ApiException.ApiException;
import com.example.booksystem.Model.Book;
import com.example.booksystem.Model.Librarian;
import com.example.booksystem.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    public List<Librarian> getLibraries() {
        List<Librarian> LibrarianList = librarianRepository.findAll();
        return LibrarianList;
    }

    public Librarian addBook(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public void updateLibrarian(Integer id, Librarian librarian) {
        Librarian updatedLibrarian = librarianRepository.findAllById(id);
        if (librarian == null) {
            throw new ApiException("the id not found ");
        }
        updatedLibrarian.setName(updatedLibrarian.getName());
        updatedLibrarian.setEmail(updatedLibrarian.getEmail());
        updatedLibrarian.setUsername(updatedLibrarian.getUsername());
        updatedLibrarian.setPassword(updatedLibrarian.getPassword());
    }

    public void deleteLibrarian(Integer id) {
        Librarian librarian = librarianRepository.findAllById(id);
        if (librarian == null) {
            throw new ApiException("");
        }
        librarianRepository.delete(librarian);
    }

    public Librarian CheckAllByUsernameAndPassword(String username, String password){
        Librarian user=librarianRepository.CheckAllByUsernameAndPassword(username,password);
        if(user==null)
        {
            throw new ApiException("User, Password Not there, Please Try Again");
        }
        return user;
    }

    public Librarian getLibrarianByEmail(String email) {
        Librarian librarian = librarianRepository.getLibrarianByEmail(email);
        if (librarian == null) {
            throw new ApiException("the email not found , make sure you are enter a right a email ");
        }
        return librarian;

    }





}
