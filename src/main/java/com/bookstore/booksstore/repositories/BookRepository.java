package com.bookstore.booksstore.repositories;

import com.bookstore.booksstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
