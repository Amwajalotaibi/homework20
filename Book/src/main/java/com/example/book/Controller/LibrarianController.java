package com.example.book.Controller;

import com.example.book.Model.Book;
import com.example.book.Model.Librarian;
import com.example.book.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianService librarianService;

    @GetMapping("/get")
    public ResponseEntity getAllLibrarian(){
        List<Librarian> librarians=librarianService.getAllLibrarian();
        return ResponseEntity.status(200).body("Librarian get");
    }
    @PostMapping("/add")
    public ResponseEntity addLibrarian(@Valid @RequestBody Librarian librarian){
       librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body("Librarian Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@Valid @RequestBody Librarian librarian,@PathVariable Integer id){
        librarianService.updateLibrarian(id, librarian);
        return ResponseEntity.status(200).body("Librarian Update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body("Librarian Delete");
    }
    @GetMapping("/get-id/{id}")
    public ResponseEntity getLibrarianById(@PathVariable Integer id){
        Librarian librarian=librarianService.findLibrarianById(id);
        return ResponseEntity.status(200).body("Get Librarian by Id");
    }


    @GetMapping("/get-email/{email}")
    public ResponseEntity getemail(@PathVariable String email){
        librarianService.findLibrarianByEmail(email);
        return ResponseEntity.status(200).body("get by email");
    }

    @GetMapping("/get-username/{email}/password/{password}")
    public ResponseEntity getLogin(@PathVariable String username,String password){
        librarianService.login(username, password);
        return ResponseEntity.status(200).body("get by User name and Password");
    }


}
