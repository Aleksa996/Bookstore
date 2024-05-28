package com.bookstore.booksstore.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private String role;

}
