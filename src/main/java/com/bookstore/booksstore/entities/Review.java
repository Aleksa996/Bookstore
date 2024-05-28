package com.bookstore.booksstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private int rating;
    private String comment;
    private Date reviewDate;

}
