package com.bookstore.booksstore.repositories;

import com.bookstore.booksstore.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
