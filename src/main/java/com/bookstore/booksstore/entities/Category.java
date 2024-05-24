package com.bookstore.booksstore.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;
    private String description;

}
