package com.example.book.Service;

import com.example.book.Model.Book;
import com.example.book.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBook(){

        return bookRepository.findAll();
    }

    public void addBook(Book book){

        bookRepository.save(book);
    }

    public void updateBook(Integer id ,Book book){
        Book oldBook=bookRepository.findBookById(id);
        if(oldBook==null) {
            throw new ArithmeticException(" Book Update ");
        }
            oldBook.setCategory(book.getCategory());
            oldBook.setAuthor(book.getAuthor());
            oldBook.setTitle(book.getTitle());
            oldBook.setIsbn(book.getIsbn());
            oldBook.setNumberofpages(book.getNumberofpages());

        bookRepository.save(book);
    }

    public void deleteBook(Integer id){
        Book oldBook=bookRepository.findBookById(id);
        if (oldBook==null){
            throw new ArithmeticException("Book Delete");
        }
        bookRepository.delete(oldBook);
    }

    public Book findBookById(Integer id){
        Book book=bookRepository.findBookById(id);
        if (book==null){
            throw new ArithmeticException("Id not found");
        }
        return book;
    }

    public List<Book> findBookByCategory(String category){
        List<Book> books=bookRepository.findBookByCategory(category);
        if (books==null){
            throw new ArithmeticException("Category not found");
        }
        return books;
    }

    public Book findBookByNumberofpagesGreaterThan(int i) {
        Book books = bookRepository.findBookByNumberofpagesGreaterThan(300);
        if (books == null) {
            throw new ArithmeticException("Number of Pages more  than 300 not found");
        }
        books.setNumberofpages(books.getNumberofpages());
        bookRepository.save(books);

        return null;
    }

    public  List<Book> findBookByAuthor(String author){
        List<Book> book=bookRepository.findBookByAuthor(author);
        if (book==null){
            throw new ArithmeticException("Author not Found");
        }
        return book;
    }

    public Book findBookByTitle(String title){
        Book book=bookRepository.findBookByTitle(title);
        if (book==null){
            throw new ArithmeticException("Title not found");
        }
        return book;
    }


}
