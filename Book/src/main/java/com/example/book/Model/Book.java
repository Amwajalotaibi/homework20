package com.example.book.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = " Title Can't be Empty")
    @Column(columnDefinition = "varchar(25) ")
    private String title;

    @NotEmpty(message = "Author Can't be Empty")
    @Column(columnDefinition = "varchar(20) ")
    private String author;

    @NotEmpty(message = " Category Can't be Empty")
    @Column(columnDefinition = "varchar(15) check(category= 'Academic' or category='Mystery' or category='Novel')")
    private String category;

    @NotNull(message = "isbn can't be null")
    @Column(columnDefinition = "int unique ")
    private Integer isbn;

    @NotNull(message = "number of pages can't be null")
    @Column(columnDefinition = "int ")
    @Size(min = 50,max = 350,message = "must be min 50 pages")
    private Integer numberofpages;

}
