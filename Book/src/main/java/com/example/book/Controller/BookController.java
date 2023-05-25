package com.example.book.Controller;

import com.example.book.Model.Book;
import com.example.book.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ipa/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


    @GetMapping("/get")
    public ResponseEntity getAllBook(){
        List<Book> books=bookService.getAllBook();
        return ResponseEntity.status(200).body("Book Get");
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@Valid @RequestBody Book book,@PathVariable Integer id){
        bookService.updateBook(id, book);
        return ResponseEntity.status(200).body("Book Update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book Delete");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getBookById(@PathVariable Integer id){
        Book book=bookService.findBookById(id);
        return ResponseEntity.status(200).body("get by id");
    }

    @GetMapping("/get-category{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        List<Book> books=bookService.findBookByCategory(category);

        return ResponseEntity.status(200).body("get by category");
    }


    @GetMapping("/get-pages/{pages}")
    public ResponseEntity getBookByNumberofpagesGreaterThan (){
        bookService.findBookByNumberofpagesGreaterThan(300);
        return ResponseEntity.status(200).body("Get by Number of page");

    }
    @GetMapping("/get-author/{author}")
    public ResponseEntity getByAuther(@PathVariable String author){
        bookService.findBookByAuthor(author);
        return ResponseEntity.status(200).body("Get by Author");
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity getByTitle(@PathVariable String title){
        bookService.findBookByTitle(title);
        return ResponseEntity.status(200).body("Get by Title");
    }


}
