package com.bookstore.booksstore.repositories;

import com.bookstore.booksstore.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
