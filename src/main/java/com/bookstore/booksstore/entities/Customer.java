package com.bookstore.booksstore.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

}
