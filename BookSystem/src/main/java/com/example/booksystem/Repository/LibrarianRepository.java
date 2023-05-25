package com.example.booksystem.Repository;

import com.example.booksystem.Model.Book;
import com.example.booksystem.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian , Integer> {


    Librarian findAllById(Integer id);

    Librarian CheckAllByUsernameAndPassword(String username, String password);

    Librarian getLibrarianByEmail(String emil);


}
