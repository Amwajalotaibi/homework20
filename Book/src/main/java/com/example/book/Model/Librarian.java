package com.example.book.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name can't be Empty")
    @Column(columnDefinition = "varchar(25)")
    private String name;

    @NotEmpty(message = "Name can't be Empty")
    @Column(columnDefinition = "varchar(25)")
    private String username;

    @NotEmpty(message = "Name can't be Empty")
    @Column(columnDefinition = "varchar(10)")
//    @Pattern(regexp = "\"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$\"\n")
    private String password;

    @Email
    @NotEmpty(message = "email  can't be Empty")
    @Column(columnDefinition = "varchar(20) unique")
    private String email;


}
