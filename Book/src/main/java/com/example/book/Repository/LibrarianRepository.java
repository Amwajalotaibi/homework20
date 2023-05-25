package com.example.book.Repository;

import com.example.book.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {
     Librarian findLibrarianById(Integer id);
     Librarian findLibrarianByUsernameAndPassword(String username,String Password);
     Librarian findLibrarianByEmail(String email);

}
