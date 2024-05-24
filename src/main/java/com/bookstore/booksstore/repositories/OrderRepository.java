package com.bookstore.booksstore.repositories;

import com.bookstore.booksstore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
