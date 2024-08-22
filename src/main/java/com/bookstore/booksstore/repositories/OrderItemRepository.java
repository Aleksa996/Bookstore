package com.bookstore.booksstore.repositories;

import com.bookstore.booksstore.entities.Order;
import com.bookstore.booksstore.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrder(Order order);

}
