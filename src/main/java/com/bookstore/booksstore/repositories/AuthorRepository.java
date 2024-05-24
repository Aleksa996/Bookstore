package com.bookstore.booksstore.repositories;

import com.bookstore.booksstore.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
