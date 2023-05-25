package com.example.book.Repository;

import com.example.book.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findBookById(Integer id);

    List<Book> findBookByAuthor(String author);
    List<Book> findBookByCategory(String category);

    Book findBookByNumberofpagesGreaterThan(Integer numberpage);

    Book findBookByTitle(String title);

}
