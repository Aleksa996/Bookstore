package com.bookstore.booksstore.repositories;

import com.bookstore.booksstore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
