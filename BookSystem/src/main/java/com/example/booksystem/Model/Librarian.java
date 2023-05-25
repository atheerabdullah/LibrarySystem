package com.example.booksystem.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(15) not null")
    @NotEmpty(message = "the name should not null")
    private String name;

    @NotEmpty(message = "the username can't be null")
    @Column(columnDefinition = "varchar(10) not null")
    private String username;

    @NotEmpty(message = "the password can't be null")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotNull(message = "the email can't be null")
    @Column(columnDefinition = "varchar(255) unique not null ")
    @Email
    private String email;

}
