package com.example.book.Service;

import com.example.book.Model.Book;
import com.example.book.Model.Librarian;
import com.example.book.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;

    public List<Librarian> getAllLibrarian(){
        return librarianRepository.findAll();
    }

    public void addLibrarian(Librarian librarian){

        librarianRepository.save(librarian);
    }

    public void updateLibrarian(Integer id ,Librarian librarian){
        Librarian oldlibrarian=librarianRepository.findLibrarianById(id);
        if(oldlibrarian==null) {
            throw new ArithmeticException(" Librarian Update ");
        }
        oldlibrarian.setName(librarian.getName());
        oldlibrarian.setUsername(librarian.getUsername());
        oldlibrarian.setEmail(librarian.getEmail());
        oldlibrarian.setPassword(librarian.getPassword());

        librarianRepository.save(librarian);
    }

    public void deleteLibrarian(Integer id){
        Librarian librarian=librarianRepository.findLibrarianById(id);
        if (librarian==null){
            throw new ArithmeticException("Librarian Delete");
        }
        librarianRepository.delete(librarian);
    }

    public Librarian findLibrarianById(Integer id){
        Librarian librarian=librarianRepository.findLibrarianById(id);
        if (librarian==null){
            throw new ArithmeticException("Id not found");
        }
        return librarian;
    }

    public Librarian findLibrarianByEmail(String email){
        Librarian librarian=librarianRepository.findLibrarianByEmail(email);
        if(librarian==null){
            throw new ArithmeticException(" Email not found");
        }
        return librarian;

    }

    public Librarian login (String username, String password){
        Librarian librarian=librarianRepository.findLibrarianByUsernameAndPassword(username,password);
        if(librarian==null){
            throw new ArithmeticException("Username And password not found ");
        }
        return librarian;
    }


}
