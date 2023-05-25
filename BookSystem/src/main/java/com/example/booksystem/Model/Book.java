package com.example.booksystem.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(200) not null")
    @NotEmpty(message = "the title should not null")
    private String title;

    @NotEmpty(message = "the author can't be null")
    @Column(columnDefinition = "varchar(200) not null")
    private String author;

    @NotEmpty(message = "the category can't be null")
    @Column(unique = true,columnDefinition = " varchar(20) not null check (category='Academic' or category='Mystery' or category='Novel')")
    private String category;

    @NotNull(message = "the ISBN cant be null")
    @Column(columnDefinition = "varchar(13) not null")
    private int ISBN;


    @Min(value = 50, message = "the minimum number of pages is 50")
    @Column(columnDefinition = " int default 50 check ( numberofpages >= 50 )")
    private int numberofpages;
}
